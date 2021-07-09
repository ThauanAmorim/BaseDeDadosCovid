package contagemPopulacional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Objeto.ObejtoConversorContagem;

public class ConversorBaseDadosContagemSujo {
    public void ler() {

        File directory = new File("");
        try {
            FileWriter arq = new FileWriter(directory.getAbsolutePath() + "/src/baseDeDados/Contagem Populacional Brasil/Contagem Populacional limpa.csv");


            Files.lines(Paths.get(directory.getAbsolutePath() + "/src/baseDeDados/Contagem Populacional Brasil/Contagem Populacional.csv"))
                .skip(3)
                .map(line -> line.split(";"))
                .map(col-> new ObejtoConversorContagem(col[6], Integer.parseInt(col[4])))
                .filter(line -> !line.getEstado().equals("Norte"))
                .filter(line -> !line.getEstado().equals("Nordeste"))
                .filter(line -> !line.getEstado().equals("Centro-Oeste"))
                .filter(line -> !line.getEstado().equals("Sul"))
                .filter(line -> !line.getEstado().equals("Sudeste"))
                .forEach(obj -> {
                    try {
                        arq.write(obj.getEstado()+";"+obj.getQuantidade()+"\n");
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                });
                arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
