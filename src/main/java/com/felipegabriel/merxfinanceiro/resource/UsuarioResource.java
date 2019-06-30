package com.felipegabriel.merxfinanceiro.resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.Valid;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipegabriel.merxfinanceiro.dto.filter.ParametroPesquisaDTO;
import com.felipegabriel.merxfinanceiro.model.Usuario;
import com.felipegabriel.merxfinanceiro.repository.UsuarioRepository;
import com.felipegabriel.merxfinanceiro.service.UsuarioService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private DataSource dataSource;

	@PostMapping
	public ResponseEntity<Usuario> salvar(@Valid @RequestBody Usuario usuario) {
		try {
			Usuario obj = usuarioService.salvarUsuario(usuario);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PutMapping
	public ResponseEntity<Usuario> atualizar(@Valid @RequestBody Usuario usuario) {
		try {
			Usuario obj = usuarioService.editarUsuario(usuario);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@DeleteMapping(value = "/{pkUsuario}")
	public ResponseEntity<Void> deletar(@Valid @PathVariable Integer pkUsuario) {
		try {
			usuarioService.deletarUsuario(pkUsuario);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping(value = "/{pkUsuario}")
	public ResponseEntity<Usuario> buscar(@Valid @PathVariable Integer pkUsuario) {
		try {
			Usuario obj = usuarioService.buscarUsuario(pkUsuario);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping(value = "/listar/")
	public ResponseEntity<List<Usuario>> listar() {
		try {
			List<Usuario> listObj = usuarioService.listarUsuarios();
			return ResponseEntity.ok(listObj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping(value = "/listar-usuario-paginacao")
	public ResponseEntity<Page<Usuario>> listarUsuarioPaginacao(@RequestParam(value = "pagina") Integer pagina,
			@RequestParam(value = "tamanho") Integer tamanho) {
		try {
			Page<Usuario> listObj = usuarioService.listarUsuariosPorPaginacao(pagina, tamanho);
			return ResponseEntity.ok(listObj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PostMapping(value = "/listar-usuario-paginacao-condiconal")
	public ResponseEntity<Page<Usuario>> listarUsuarioPaginacaoFilter(@RequestBody List<ParametroPesquisaDTO> parametros) {
		try {
			Page<Usuario> listObj = usuarioService.listarUsuariosPorPaginacaoFilter(parametros);
			return ResponseEntity.ok(listObj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping(value = "/email/{email}")
	public ResponseEntity<Usuario> listar(@Valid @PathVariable String email) {
		try {
			Usuario obj = usuarioService.buscarUsuarioPorEmail(email);
			return ResponseEntity.ok(obj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping(value = "/nome/{nome}")
	public ResponseEntity<List<Usuario>> buscarUsuarioPorNome(@Valid @PathVariable String nome) {
		try {
			List<Usuario> listObj = usuarioService.buscarUsuarioPorNome(nome);
			return ResponseEntity.ok(listObj);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "/relatorio/usuarios")
	public void gerarRelatorioUsuariosGeral(HttpServletResponse response) throws JRException, SQLException, IOException {
		InputStream reportStream = new FileInputStream("C:\\Users\\pinhe\\Documents\\relatorios\\usuarios.jasper");
		Map<String, Object> params = new HashMap<>();
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource.getConnection());
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition",
				"attachment;filename=relatorio-de-usuarios " + new Date().toString() + ".pdf");
		OutputStream outputStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
	}
	
	
	
}
