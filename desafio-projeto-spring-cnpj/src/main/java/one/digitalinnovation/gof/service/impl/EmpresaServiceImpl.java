package one.digitalinnovation.gof.service.impl;


import one.digitalinnovation.gof.model.Dados;
import one.digitalinnovation.gof.model.DadosRepository;
import one.digitalinnovation.gof.model.Empresa;
import one.digitalinnovation.gof.model.EmpresaRepository;
import one.digitalinnovation.gof.service.CnpjService;
import one.digitalinnovation.gof.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private DadosRepository dadosRepository;
    @Autowired
    private CnpjService cnpjService;

    @Override
    public Iterable<Empresa> buscarTodos() {
        // Buscar todas as Empresas.
        return empresaRepository.findAll();
    }

    @Override
    public Empresa buscarPorId(Long id) {
        // Buscar Empresa por ID.
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.get();
    }

    @Override
    public void inserir(Empresa empresa) {
        salvarEmpresaComCnpj(empresa);
    }

    @Override
    public void atualizar(Long id, Empresa empresa) {
        // Buscar Empresa por ID, caso exista:
        Optional<Empresa> empresaBd = empresaRepository.findById(id);
        if (empresaBd.isPresent()) {
            salvarEmpresaComCnpj(empresa);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Empresa por ID.
        empresaRepository.deleteById(id);
    }

    private void salvarEmpresaComCnpj(Empresa empresa) {
        // Verificar se os Dados da Empresa já existe (pelo CNPJ).
        String cnpj = empresa.getDados().getCnpj();
        Dados dados = dadosRepository.findById(cnpj).orElseGet(() -> {
            // Caso não exista, integrar a API e persistir o retorno.
            Dados novosDados = cnpjService.consultarCnpj(cnpj);
            dadosRepository.save(novosDados);
            return novosDados;
        });
        empresa.setDados(dados);
        // Inserir Empresa, vinculando os Dados (novo ou existente).
        empresaRepository.save(empresa);
    }

}
