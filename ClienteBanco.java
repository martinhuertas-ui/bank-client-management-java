public class ClienteBanco {
   int NumCuenta;
   String NumCed;
   String Nombre;
   double Capital;
   int TipoCuenta;
   public ClienteBanco()
   {
       this.NumCuenta=0;
       this.NumCed="";
       this.Nombre="";
       this.Capital=0.0;
       this.TipoCuenta=0;
   }
   public ClienteBanco(int NumCuenta,String NumCed, String Nombre, double Capital, int TipoCuenta)
   {
       this.NumCuenta=NumCuenta;
       this.NumCed=NumCed;
       this.Nombre=Nombre;
       this.Capital=Capital;
       this.TipoCuenta=TipoCuenta;
   }
 
   public int getNumCuenta() {
       return NumCuenta;
   }
 
   public void setNumCuenta(int NumCuenta) {
       this.NumCuenta = NumCuenta;
   }
 
   public String getNumCed() {
       return NumCed;
   }
 
   public void setNumCed(String NumCed) {
       this.NumCed = NumCed;
   }
 
   public String getNombre() {
       return Nombre;
   }
 
   public void setNombre(String Nombre) {
       this.Nombre = Nombre;
   }
 
   public double getCapital() {
       return Capital;
   }
 
   public void setCapital(double Capital) {
       this.Capital = Capital;
   }
 
   public int getTipoCuenta() {
       return TipoCuenta;
   }
 
   public void setTipoCuenta(int TipoCuenta) {
       this.TipoCuenta = TipoCuenta;
   }
 
   
   
}