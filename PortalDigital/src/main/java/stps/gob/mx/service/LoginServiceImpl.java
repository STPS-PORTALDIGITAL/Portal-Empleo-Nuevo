package stps.gob.mx.service;


import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

import java.util.stream.Collectors;



import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.UsuarioConverter;
import stps.gob.mx.domain.Candidato;
import stps.gob.mx.domain.CodigoPostal;
import stps.gob.mx.domain.Colonia;
import stps.gob.mx.domain.Convocatorias;
import stps.gob.mx.domain.Entidad;
import stps.gob.mx.domain.Feriasempleo;
import stps.gob.mx.domain.Municipio;
import stps.gob.mx.domain.Usuario;
import stps.gob.mx.dto.BusquedaDTO;
import stps.gob.mx.dto.CandidatoDTO;
import stps.gob.mx.dto.InicioDTO;
import stps.gob.mx.dto.MapaDTO;
import stps.gob.mx.dto.OfertaEmpleoDTO;
import stps.gob.mx.dto.UsuarioDTO;
import stps.gob.mx.repositories.CandidatoRepository;
import stps.gob.mx.repositories.ColoniaRepository;
import stps.gob.mx.repositories.ConvocatoriasRepository;
import stps.gob.mx.repositories.EntidadRepository;
import stps.gob.mx.repositories.FeriasempleoRepository;
import stps.gob.mx.repositories.MunicipioRepository;
import stps.gob.mx.repositories.OfertaEmpleoRepository;
import stps.gob.mx.repositories.UsuarioRepository;
import stps.gob.mx.util.SendEmail;

@Service
public class LoginServiceImpl  implements LoginService {
	final static Logger log = Logger.getLogger(LoginServiceImpl.class);
	
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	OfertaEmpleoRepository ofertaEmpleoRepository;
	
	@Autowired
	CandidatoRepository candidatoRepository;
	
	@Autowired
	EntidadRepository entidadRepository;
	
	@Autowired
	MunicipioRepository municipioRepository;
	
	@Autowired
	ColoniaRepository coloniaRepository;
	
	@Autowired
	ConvocatoriasRepository convocatoriasRepository;
	
	@Autowired
	FeriasempleoRepository feriasempleoRepository;
	
	@Autowired
	LogService logService;
	
	@Autowired
    Environment enviroment;
	
	@Value("${stps.gob.mx.correo}")
    private String correo;
	@Value("${stps.gob.mx.ingreso}")
    private String ingreso;
	
	/********************************************************************************************************
	 * Nombre del metodo: 	valida usuario
	 * Descripcion: 		Metodo que realiza la validacion del usuario
	 * Entrada:				UsuarioDTO
	 * Salida:				UsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			TBD
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	
	@Override
	public UsuarioDTO validaUsuario(UsuarioDTO vo) {
		UsuarioDTO 				out 	= new UsuarioDTO();
		List<Usuario> 			list 	= null ;
		Usuario 				usuario = new Usuario();
		UsuarioConverter		serv 	= new UsuarioConverter();

		
		try {

			out.setResult(Constantes.FALSE);
			if (vo.getUsuario() != null && vo.getPasswrd() != null) {
				list = repository.findByUsuario(vo.getUsuario());
				if (list != null) {
					if (list.size() > 0) {
							for (int i=0; i < list.size() ; i++) {
								usuario = list.get(i);
								
								if (usuario.getPasswrd().equals(vo.getPasswrd().trim())) {
									out = serv.toUsuarioDTO(usuario, out);
									out.setResult(Constantes.TRUE);
									out.setMessage(Constantes.VALIDACION_USUARIO);
									out.setToken(getJWTToken(vo.getUsuario()));
								}else {
									out.setMessage(Constantes.PASSWORD_INVALIDO);
								}
							}
							
					}else {
						out.setMessage(Constantes.USUARIO_NO_ENCONTRADO);
					}
				}else {
					out.setMessage(Constantes.USUARIO_NO_ENCONTRADO);
				}
			}else {
				out.setMessage(Constantes.USUARIO_NULO);
				
			}
			vo=(UsuarioDTO)logService.setValues(vo, "Login", "validaUsuario", "LoginController");
			vo.setComments(out.getMessage());
			logService.recordLog(vo);
		}catch(Exception e) {
			vo.setComments(Constantes.ERROR_EXCEPCION+"/"+vo.getServicio()+"/"+vo.getMetodo());
			out.setMessage(vo.getComments());
			logService.recordException(e, vo);
		}
		
		
		return out;
	}

	/********************************************************************************************************
	 * Nombre del metodo: 	Recuperacion de contrasena
	 * Descripcion: 		Metodo que realiza la recuperacion de la contrasena asociada del usuario
	 * Entrada:				UsuarioDTO
	 * Salida:				UsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			TBD
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public UsuarioDTO recuperaContrasena(UsuarioDTO vo) {
		UsuarioDTO 				out 	= new UsuarioDTO();
		List<Usuario> 			list 	= null ;
		Usuario 				usuario = new Usuario();
		UsuarioConverter		serv 	= new UsuarioConverter();

		
		try {
			out.setResult(Constantes.FALSE);

			if (vo.getEmail() != null) {
				//list = repository.findByUsuario(vo.getUsuario());
				list = repository.findByEmail( vo.getEmail() );
				if (list != null) {
					if (list.size() > 0) {
							for (int i=0; i < list.size() ; i++) {
								usuario = list.get(i);
								
								if (usuario.getEmail().equals(vo.getEmail())) {
									out = serv.toUsuarioDTO(usuario, out);
									try {
										SendEmail sendEmail = new SendEmail();
										sendEmail.enviar(
												"Se solicito la recuperación de Usuario y Contraseña\n" +
												"Usuario:\t" + usuario.getUsuario() + "\n" +
												"Password:\t" + usuario.getPasswrd() + "\n" +
												"Si estos datos no los solicitaste tu, favor de notificarlo al administrador del Portal del Empleo", 
												usuario.getEmail(), 
												"Recuperacion de Contraseña",
												correo, ingreso);
										
										out.setResult(Constantes.TRUE);
										out.setMessage(Constantes.RECUPERACION_CONTRASENA);
									}catch( Exception e ) {
										logService.recordException(e, vo);
										out.setResult(Constantes.FALSE);
										out.setMessage( Constantes.RECUPERACION_CONTRASENA_FALLA_EMAIL );
									}
								}else {
									out.setMessage(Constantes.FRASE_INVALIDA);
								}
							}
							
					}else {
						out.setMessage(Constantes.USUARIO_NO_ENCONTRADO);
					}
				}else {
					out.setMessage(Constantes.USUARIO_NO_ENCONTRADO);
				}
			}
			vo=(UsuarioDTO)logService.setValues(vo, "Login", "recuperaContrasena", "LoginController");
			vo.setComments(out.getMessage());
			logService.recordLog(vo);
		}catch(Exception e) {
			vo.setComments(Constantes.ERROR_EXCEPCION+"/"+vo.getServicio()+"/"+vo.getMetodo());
			out.setMessage(vo.getComments());
			logService.recordException(e, vo);
		}
		
		
		return out;
	}


	/********************************************************************************************************
	 * Nombre del metodo: 	NUevo usuario
	 * Descripcion: 		Metodo que realiza el registro de un nuevo Usuario
	 * Entrada:				UsuarioDTO
	 * Salida:				UsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			TBD
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public UsuarioDTO nuevoUsuario(UsuarioDTO vo) {
		UsuarioDTO 				out 		= new UsuarioDTO();
		UsuarioDTO				registro	= new UsuarioDTO();
		Usuario 				usuario 	= new Usuario();
		Usuario 				newUser 	= new Usuario();
		UsuarioConverter		serv 		= new UsuarioConverter();

		
		BasicConfigurator.configure();
		try {
			usuario = serv.toUsuarioAlta(vo, usuario);
			registro = existeUsuario(vo);
			if (!registro.isResult()) {
				newUser = repository.save(usuario);
				
				out.setResult(Constantes.TRUE);
				out.setMessage(Constantes.NUEVO_USUARIO);

			}else {
				out.setResult(Constantes.FALSE);
				out.setMessage(Constantes.USUARIO_DUPLICADO);
			}
			vo=(UsuarioDTO)logService.setValues(vo, "Login", "nuevoUsuario", "LoginController");
			vo.setComments(out.getMessage());
			logService.recordLog(vo);
		}catch(Exception e) {
			vo.setComments(Constantes.ERROR_EXCEPCION+"/"+vo.getServicio()+"/"+vo.getMetodo());
			out.setMessage(vo.getComments());
			logService.recordException(e, vo);
		}
		
		return out;
	}
	/********************************************************************************************************
	 * Nombre del metodo: 	existeUsuario
	 * Descripcion: 		Metodo que valida la existencia de un usuario registrado en la bd
	 * Entrada:				UsuarioDTO
	 * Salida:				UsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			TBD
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	
	private UsuarioDTO existeUsuario (UsuarioDTO vo) {
		UsuarioDTO			out 	= new UsuarioDTO();
		List<Usuario> 		list 	= null;
		List<Usuario> 		listEmail 	= null;
		
		try {

			out.setResult(Constantes.FALSE);
			if (vo.getUsuario() != null) {
				if (vo.getUsuario().length() > 0) {
					list = repository.findByUsuario(vo.getUsuario()); 
					listEmail = repository.findByEmail(vo.getEmail()); 
					if (list != null ) {
						if (list.size() > 0) {
							if (listEmail != null) {
								if (listEmail.size() > 0) {
									out.setResult(Constantes.TRUE);
									out.setMessage(Constantes.OPERACION_EXITOSA);
								}
							}
						}else{
							out.setMessage(Constantes.USUARIO_NO_ENCONTRADO);	
						}
					}else {
						out.setMessage(Constantes.USUARIO_NO_ENCONTRADO);	
					}
				}else {
					out.setMessage(Constantes.USUARIO_NULO);
				}
			}else {
				out.setMessage(Constantes.USUARIO_NULO);
			}
		}catch(Exception e) {
			vo.setComments(Constantes.ERROR_EXCEPCION+"/"+vo.getServicio()+"/"+vo.getMetodo());
			out.setMessage(vo.getComments());
			logService.recordException(e, vo);
		}
		return out;
	}

	
	/********************************************************************************************************
	 * Nombre del metodo: 	getJWTToken
	 * Descripcion: 		Metodo que genera el token de autenticación
	 * Entrada:				UsuarioDTO
	 * Salida:				UsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			TBD
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	private String getJWTToken(String username) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	@Override
	public InicioDTO homeSinSesion() {
		InicioDTO 		data 					= new InicioDTO();
		List<String> 	listaEmpleos 			= new ArrayList<String>();
		List<String> 	listaMunicipiosEntidad 	= new ArrayList<String>();
		List<String> 	listConvocatorias   	= new ArrayList<String>();
		List<String> 	listaFerias   		    = new ArrayList<String>();
		List<Entidad> 	listaEntidad 			= new ArrayList<Entidad>();
		List<Candidato> listaCandidatos         = null;
		List<Convocatorias> listaConvocatorias  = null;
		List<Feriasempleo> feriaempleo			= null;
		int 			numeroOfertasEmpleo 	=	0;
		int 			numeroCandidatos		=	0;

		
		BasicConfigurator.configure();
		try {
			listaEmpleos 			= ofertaEmpleoRepository.busquedaPuestos(Constantes.ACTIVO);
			numeroOfertasEmpleo 	= ofertaEmpleoRepository.getCount(Constantes.ACTIVO);
			listaCandidatos			= candidatoRepository.findAllRecords(Constantes.ACTIVO);
			numeroCandidatos 		= listaCandidatos.size();
			listaEntidad        	= entidadRepository.findAllRecords(Constantes.ACTIVO);
			listaConvocatorias  	= convocatoriasRepository.findAllRecords(Constantes.ACTIVO);
			feriaempleo				= feriasempleoRepository.findAllRecords(Constantes.ACTIVO);
			listConvocatorias   	= getConvocatorias(listaConvocatorias);
			listaFerias		        = getFerias(feriaempleo);
			listaMunicipiosEntidad 	= getMunicipiosEntidad(listaEntidad);
			
			data.setListaEmpleos(listaEmpleos);
			data.setNumeroOfertasEmpleo(numeroOfertasEmpleo);
			data.setNumeroCandidatos(numeroCandidatos);
			data.setListaMunicipiosEntidad(listaMunicipiosEntidad);
			data.setListaConvocatorias(listConvocatorias);
			data.setListaFerias(listaFerias);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return data;
	}	
	
	private  List<String> getFerias (List<Feriasempleo> list) {
		List<String> listFerias = new ArrayList<String>();
		Feriasempleo ferias = new Feriasempleo();
		
		try {
			for (int i=0; i<list.size();i++) {
				ferias = new Feriasempleo();
				ferias = list.get(i);
				listFerias.add(ferias.getTitulo());
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listFerias;
		
	}
	
	
	private  List<String> getConvocatorias (List<Convocatorias> list) {
		List<String> listConvocatorias = new ArrayList<String>();
		Convocatorias convocatorias = new Convocatorias();
		
		try {
			for (int i=0; i<list.size();i++) {
				convocatorias = new Convocatorias();
				convocatorias = list.get(i);
				listConvocatorias.add(convocatorias.getDescripcion());
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listConvocatorias;
		
	}
	
	private List<String> getMunicipiosEntidad (List<Entidad> 	listaEntidad){
		List<String> 	listaMunicipiosEntidad 	= new ArrayList<String>();
		List<Municipio> listMunicipios = new ArrayList<Municipio>();
		Entidad         entidad                 = null;
		Municipio		municipio				= null;
		String          entidadMunicipio        = null;
		List<Colonia>   listaColonias			= null;
		Colonia			colonia					= null;
		
		BasicConfigurator.configure();
		try {
			for (int i=0; i < listaEntidad.size(); i++ ) {
				entidad = new Entidad();
				
				entidad = listaEntidad.get(i);

				
				listMunicipios = municipioRepository.findByEntidad(entidad.getId());
				for (int j =0; j< listMunicipios.size(); j++) {
					municipio = new Municipio();
					entidadMunicipio = new String("");
					municipio = listMunicipios.get(j);
					listaColonias=municipio.getColonias();
					for (int k=0; k < listaColonias.size(); k++) {
						colonia = new Colonia();
						colonia = listaColonias.get(k);

						entidadMunicipio = "Colonia: "+colonia.getDescripcion()+" CP: "+colonia.getCodigopostal().getCodigoPostal()+" "+municipio.getDescripcion()+","+entidad.getDescripcion();
						listaMunicipiosEntidad.add(entidadMunicipio);
					}

				}
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listaMunicipiosEntidad;
		
	}

	@Override
	public BusquedaDTO busquedaSinSesion(BusquedaDTO dto) {

		List<CandidatoDTO> listCandidatos = new ArrayList<CandidatoDTO>();
		List<OfertaEmpleoDTO> listEmpleos = new ArrayList<OfertaEmpleoDTO>();
		CandidatoDTO candidato = new CandidatoDTO();
		OfertaEmpleoDTO empleo = new OfertaEmpleoDTO();
		
		try {
			candidato.setTitulo("Arquitecto");
			candidato.setSalarioMensualNeto("$30,000.00");
			candidato.setDescription("Especialista en construccion de edificios con Inteligencia Artificial");
			candidato.setUbicacion("Av Insurgentes Sur 1350 Col Los Morales, Ciudad de Mexico");
			listCandidatos.add(candidato);
			
			empleo.setTitulo("Arquitecto IA");
			empleo.setSalarioMensualNeto("$30,000.00");
			empleo.setDescription("Especialista en construccion de edificios con Inteligencia Artificial");
			empleo.setUbicacion("Av Insurgentes Sur 1350 Col Los Morales, Ciudad de Mexico");
			listEmpleos.add(empleo);
			
			dto.setListCandidatos(listCandidatos);
			dto.setListEmpleos(listEmpleos);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return dto;
	}

	@Override
	public MapaDTO mostrarMapaSinSesionCandidato(CandidatoDTO in) {
		MapaDTO maps = new MapaDTO();
		String urlGoogleMaps = new String("");
		
		try {
			urlGoogleMaps = "https://goo.gl/maps/zucgobkQUPyxZgBB7";
			maps.setUrlGoogleMaps(urlGoogleMaps);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return maps;
	}

	@Override
	public MapaDTO mostrarMapaSinSesionEmpleo(OfertaEmpleoDTO in) {
		MapaDTO maps = new MapaDTO();
		String urlGoogleMaps = new String("");
		
		try {
			urlGoogleMaps = "https://goo.gl/maps/YSvptAQNuxbDFCDaA"
					+ "";
			maps.setUrlGoogleMaps(urlGoogleMaps);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return maps;
	}
}
