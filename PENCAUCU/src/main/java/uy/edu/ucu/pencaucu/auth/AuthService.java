package uy.edu.ucu.pencaucu.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uy.edu.ucu.pencaucu.dto.UsuarioDTO;
import uy.edu.ucu.pencaucu.jwt.JwtService;
import uy.edu.ucu.pencaucu.model.Usuario;
import uy.edu.ucu.pencaucu.repo.IUsuarioRepo;
import uy.edu.ucu.pencaucu.util.DozerUtil;

@Service
public class AuthService implements IAuthService{
	
	@Autowired
	private IUsuarioRepo iUsuarioRepo;
	
	@Autowired
	private JwtService JwtService;
	
	@Override
	public AuthResponse loginUsuario(UsuarioDTO usuarioDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthResponse createUsuario(UsuarioDTO usuarioDTO) {
		
		/// Usar Dozer para mapear DTO a entidad
	    Usuario usuario = DozerUtil.GetINSTANCE().getMapper().map(usuarioDTO, Usuario.class);
	    		
	    // Guardar el objeto usuario en la base de datos
	    iUsuarioRepo.save(usuario);
	    
	    return AuthResponse.builder()
	    		.token(JwtService.getToken(usuario))
	    		.build();
	}

}
