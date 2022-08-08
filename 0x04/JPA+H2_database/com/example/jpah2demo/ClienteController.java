package com.example.jpah2demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @PostMapping("/addClient")
    public ResponseEntity<Cliente> addClient(@RequestBody Cliente cliente) {
        for (Endereco endereco : cliente.getEnderecos()){
            endereco.setCliente(cliente);
        }
        for (Telefone telefone : cliente.getTelefones()){
            telefone.setCliente(cliente);
        }
        Cliente savedClient = clienteRepository.save(cliente);

        return ResponseEntity.ok().body(savedClient);
    }

    @GetMapping("/findAllClients")
    public ResponseEntity<List<Cliente>> findAllClients() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/findClientById/{id}")
    public ResponseEntity<Cliente> findClientById(@PathVariable("id") Long idClient) {
        Optional<Cliente> cliente = clienteRepository.findById(idClient);
        Cliente findCliente = cliente.get();
        if (!cliente.isPresent()) {
            return ResponseEntity.ok().body(null);
        } else {
            return ResponseEntity.ok().body(findCliente);
        }
    }

    @DeleteMapping("/removeClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCliente(@PathVariable("id") Long idClient){
        clienteRepository.deleteById(idClient);
    }

    @PutMapping("/updateClientById/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente){
        Optional<Cliente> findClient = clienteRepository.findById(id);
        Cliente savedClient = findClient.get();
        if (savedClient != null) {
            for (Endereco endereco : cliente.getEnderecos()){
                savedClient.getEnderecos().add(endereco);
                endereco.setCliente(savedClient);
            }
            for (Telefone telefone : cliente.getTelefones()){
                savedClient.getTelefones().add(telefone);
                telefone.setCliente(savedClient);
            }
            clienteRepository.save(savedClient);
        }
    }

}

