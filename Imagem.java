
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


public class Imagem extends JPanel {
    private BufferedImage figura;
    
    public Imagem(){
        super();
    }
    public void setFigura(BufferedImage figura) {
        this.figura = figura;
    }
    public BufferedImage getFigura() {
        return figura;
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponents(g);
        g.drawImage(figura,0,0,null);
    }
    public void atribuiImagem(BufferedImage _buffer){
        figura=_buffer;
        repaint();
    }
    public int getVermelho(int x, int y){
    
    Color color = new Color(figura.getRGB(x,y));
    int vcor=(int)color.getRed();
    
    return vcor;
    }
    public int getVerde(int x, int y){
    
    Color color = new Color(figura.getRGB(x,y));
    int vcor=(int)color.getGreen();
    
    return vcor;
    }
    public int getAzul(int x, int y){
    
    Color color = new Color(figura.getRGB(x,y));
    int vcor=(int)color.getBlue();
    
    return vcor;
    }
    public double euclidiana(int x1, int x2, int y1, int y2)
    {
    return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
  public double cityBlock(int x1, int x2, int y1, int y2)
  {
      return Math.abs(x1-x2)+ Math.abs(y1-y2);
  }
  public double chessBoard(int x1, int x2, int y1, int y2)
  {
      return Math.max(Math.abs(x1-x2),Math.abs(y1-y2));
  }
    public BufferedImage Copiar()
    {
        BufferedImage buf = new BufferedImage(figura.getWidth(), figura.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < figura.getWidth(); i++) {
        for (int j = 0; j < figura.getHeight(); j++) {
        Color cor = new Color(figura.getRGB(i, j));
        int r = (int) (cor.getRed());
        int g = (int) (cor.getGreen());
        int b = (int) (cor.getBlue());
        Color color = new Color(r, g, b);
        buf.setRGB(i, j, color.getRGB());
        }
        }
        return buf;
    }
    public BufferedImage Negativo(){
        
    BufferedImage buf = new BufferedImage(figura.getWidth(), figura.getHeight(), BufferedImage.TYPE_INT_RGB);

    for (int i = 0; i < figura.getWidth(); i++) {
    for (int j = 0; j < figura.getHeight(); j++) {
    Color cor = new Color(figura.getRGB(i, j));
    int r = 255 - (int) (cor.getRed());
    int g = 255 - (int) (cor.getGreen());
    int b = 255 - (int) (cor.getBlue());
    Color color = new Color(r, g, b);
    buf.setRGB(i, j, color.getRGB());
    }
    }
    return buf;
    }
    public BufferedImage Binario(){
        
    BufferedImage buf = new BufferedImage(figura.getWidth(), figura.getHeight(), BufferedImage.TYPE_INT_RGB);
    Color color;

    for (int i = 0; i < figura.getWidth(); i++) {
    for (int j = 0; j < figura.getHeight(); j++) {
    Color cor = new Color(figura.getRGB(i, j));
    int r = (int) (cor.getRed());
    int g = (int) (cor.getGreen());
    int b = (int) (cor.getBlue());
    int c = ((r+g+b))/3;
    if(c>127)
    {
      color = new Color(255, 255, 255);    
    }
    else
    {
      color = new Color(0, 0, 0);
    }
    buf.setRGB(i, j, color.getRGB());
    }
    }
    return buf;
    }
    public void vizinhanca4(int x, int y, Color cor){
    Color cor_atual= new Color(figura.getRGB(x,y));

    if(cor_atual.getRGB()==cor.getRGB()){
    figura.setRGB(x,y,new Color(255,0,0).getRGB());
    vizinhanca4(x-1,y,cor);
    vizinhanca4(x+1,y,cor);
    vizinhanca4(x,y-1,cor);
    vizinhanca4(x,y+1,cor);
    }
    }
    public void vizinhanca8(int x, int y, Color cor){
    Color cor_atual= new Color(figura.getRGB(x,y));

    if(cor_atual.getRGB()==cor.getRGB()){
    figura.setRGB(x,y,new Color(255,0,0).getRGB());
    vizinhanca8(x-1,y,cor);
    vizinhanca8(x+1,y,cor);
    vizinhanca8(x,y-1,cor);
    vizinhanca8(x,y+1,cor);
    vizinhanca8(x-1,y-1,cor);
    vizinhanca8(x+1,y+1,cor);
    vizinhanca8(x+1,y-1,cor);
    vizinhanca8(x-1,y+1,cor);
    }
    }
    
}
