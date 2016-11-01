/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.image.BufferedImage;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author jose
 */
public class Histograma {   
    
    private BufferedImage imagem; 
    private JFreeChart grafico;
    private float [] cinzas = new float[256];
    
    public Histograma(BufferedImage buffer){
        this.imagem = buffer;
        this.grafico = this.criaGrafico();
    }
    
    public JFreeChart getChart(){
        return this.grafico;
    }
    
    public void calculaFrequencia(){
        for (int i = 0; i < this.imagem.getWidth(); i++) {
            for (int j = 0; j < this.imagem.getHeight(); j++) {
                Color c = new Color (this.imagem.getRGB(i, j));
                cinzas[intervalo((c.getBlue()+c.getGreen()+c.getRed())/3)] += 1; 
            }
        }
        normaliza();
    }
    public void normaliza(){
        for (int i = 0; i < cinzas.length; i++) {
            cinzas[i] = cinzas[i]/(imagem.getWidth()*imagem.getHeight());
        }
    }
    
    public JFreeChart criaGrafico(){
        this.calculaFrequencia();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        //insere os valores no dataset para carregar no grafico
        for (int x = 0; x < this.cinzas.length; x++) {
            String v2 = String.valueOf(x);
           // String v2 = x == 0 || 16 % x == 0? String.valueOf(x) : "";
            dataset.addValue(cinzas[x],"Escala de Cinzas", v2);
        }
        
        JFreeChart chart = ChartFactory.createAreaChart(
                "Histograma", // chart title
                "Pixels", // domain axis label
                "Quantidade", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips?
                false // URLs?
                );
     
        return chart;
    }
    public static int intervalo(int a){
    if (a<0)
        return 0;
    else if(a>255)
        return 255;
    else 
        return a;
   }

}//fim da classe