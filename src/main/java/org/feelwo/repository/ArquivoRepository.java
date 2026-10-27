
package repository;

import org.feelwo.model.RegistroDiario;
import org.feelwo.model.enums.Intensidade;
import org.feelwo.model.enums.Sintoma;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Map;


public class ArquivoRepository {

    private static final String PASTA = "registros"; // cirie variavel PPASTA q Guarda o nome da pasta.

    public void salvar(RegistroDiario registro) throws IOException {
        File pasta = new File(PASTA);//cria obj q representa caminho da pasta
        pasta.mkdir(); // Tenta criar a pasta.

        String nomeArquivo = new SimpleDateFormat("dd-MM-yyyy").format(registro.getData().getTime()) + ".txt";

        File arquivo = new File(pasta, nomeArquivo); // precisa dizer ao Java onde o arquivo ficará e qual será o nome dele. pasta indica odne ficara e nomeArquivo qual sera o nome

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Map.Entry<Sintoma, Intensidade> par :
                    registro.getSintomas().entrySet()) {
                bw.write(par.getKey() + ";" + par.getValue());
                bw.newLine();
            }
        }

        //fileWriter abre o arquivo para escrever, se n existir cria
        //BufferedWriter bw: cria a variável bw, que você usará para escrever no arquivo.
    }   //O Map armazena informações em pares: uma chave (key) e um valor (value). aqui a chave eh sintoma e valor intensidade
}       //entrySet() --> pega tds entradas do mapa. uma entrada eh um par formado por uma chave  um valor
        //par: nome da variável que vai representar cada entrada durante a repetição.
        //Map.Entry é uma única linha do seu mapa, contendo um sintoma e sua intensidade.
        //par.getKey() Pega a chave da entrada atual, ou seja, o sintoma, par.getValue() Pega o valor da entrada atual, ou seja, a intensidade.
        //bw.write(...) junta o sintoma, o ponto e vírgula e a intensidade, e escreve o resultado no arquivo.