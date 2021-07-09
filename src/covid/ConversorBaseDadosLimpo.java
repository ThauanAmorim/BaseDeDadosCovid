package covid;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import Objeto.ObjetoConversorCovid;

public class ConversorBaseDadosLimpo {
    public void ler() {

        File directory = new File("");
        HashMap<String, Integer> capitalCities = criarHashMap();

        capitalCities = somarCasosPorEstado(directory, capitalCities);
        try {
            FileWriter arq = new FileWriter(directory.getAbsolutePath() + "/src/baseDeDados/covid/baseCovidLimpo.csv");

            for(String key : capitalCities.keySet()){
                arq.write(key+";"+capitalCities.get(key)+"\n");
            }
            arq.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private HashMap<String, Integer> criarHashMap() {
        HashMap<String, Integer> capitalCities = new HashMap<String, Integer>();

        capitalCities.put("AC", 0);
        capitalCities.put("AL", 0);
        capitalCities.put("AP", 0);
        capitalCities.put("AM", 0);
        capitalCities.put("BA", 0);
        capitalCities.put("CE", 0);
        capitalCities.put("DF", 0);
        capitalCities.put("ES", 0);
        capitalCities.put("GO", 0);
        capitalCities.put("MA", 0);
        capitalCities.put("MT", 0);
        capitalCities.put("MS", 0);
        capitalCities.put("MG", 0);
        capitalCities.put("PA", 0);
        capitalCities.put("PB", 0);
        capitalCities.put("PR", 0);
        capitalCities.put("PE", 0);
        capitalCities.put("PI", 0);
        capitalCities.put("RJ", 0);
        capitalCities.put("RN", 0);
        capitalCities.put("RS", 0);
        capitalCities.put("RO", 0);
        capitalCities.put("RR", 0);
        capitalCities.put("SC", 0);
        capitalCities.put("SP", 0);
        capitalCities.put("SE", 0);
        capitalCities.put("TO", 0);

        return capitalCities;
    }

    private HashMap<String, Integer> somarCasosPorEstado(File directory, HashMap<String, Integer> capitalCities) {
        try {
            Files.lines(Paths.get(directory.getAbsolutePath() + "/src/baseDeDados/covid/baseCovidSuja.csv"))
                .skip(1)
                .map(line -> line.split(";"))
                .map(col-> new ObjetoConversorCovid(col[0], col[1], Integer.parseInt(col[3]), col[2]))
                .forEach(obj -> {
                    int valor = capitalCities.get(obj.getEstado());
                    valor += obj.getCasosAcumulado();
                    capitalCities.replace(obj.getEstado(), valor);
                });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return capitalCities;
    }
}
