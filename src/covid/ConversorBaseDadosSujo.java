package covid;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import Objeto.ObjetoConversorCovid;

public class ConversorBaseDadosSujo {
    public void ler() {

        File directory = new File("");
        try {
            FileWriter arq = new FileWriter(directory.getAbsolutePath() + "/src/baseDeDados/covid/baseCovidSuja.csv");


            Files.lines(Paths.get(directory.getAbsolutePath() + "/src/baseDeDados/covid/HIST_PAINEL_COVIDBR_2020_Parte1_08jul2021.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(col-> new ObjetoConversorCovid(col[0], col[1], Integer.parseInt(col[10]), col[7]))
                .filter(obj -> obj.getData().equals("2020-07-31"))
                .forEach(obj -> {
                    try {
                        arq.write(obj.getRegiao()+";"+obj.getEstado()+";"+obj.getData()+";"+obj.getCasosAcumulado()+"\n");
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
