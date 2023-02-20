package client.microservices.ms.application;

import client.microservices.ms.application.representation.ClienteSaveRequest;
import client.microservices.ms.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("clientes")
public class ClientesResource {

    @Autowired
    private final ClienteService service;

    @GetMapping
    public String status(){
        log.info("Obtento o status do microservices do cliente!");
        return "API ESTÁ OK";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest clientes) {
        Cliente cliente = clientes.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity dadosClientes(@RequestParam String cpf) {
        Optional<Cliente> byCpf = service.getByCpf(cpf);

        if (byCpf.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byCpf);
    }
}
