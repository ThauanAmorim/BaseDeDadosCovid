import java.util.HashMap;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import covid.ConversorBaseDadosLimpo;

public class Calculadora{

    public void calcular(){
        String directoryContagem = "/src/baseDeDados/Contagem Populacional Brasil/Contagem Populacional limpa.csv";
        String directoryCovid = "/src/baseDeDados/covid/baseCovidLimpo.csv";
        
        HashMap<String, Integer> covid = new ConversorBaseDadosLimpo().criarHashMap();
        HashMap<String, Integer> contagem = new ConversorBaseDadosLimpo().criarHashMap();

        covid = somarPorEstado(directoryCovid, contagem);
    }

    private HashMap<String, Integer> somarPorEstado(String caminho, HashMap<String, Integer> capitalCities) {
        Reader directory = null;
        try {
            directory = new FileReader(caminho);
            Files.lines(directory.)
                .skip(1)
                .map(line -> line.split(";"))
                .map(col-> new ObjetoConversorCovid(Integer.parseInt(col[3]), col[2]))
                .forEach(System.out::println);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return capitalCities;
    }
}