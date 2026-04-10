import javax.swing.*;
 
public class InterfazBanco03 {
public static ClienteBanco ArregloCliente[];
public static int TamArreglo;
public static int Cont=0;
 
public static void TamañoArreglo() {
    TamArreglo = Integer.parseInt(JOptionPane.showInputDialog(null,"digita tamaño del vector"));
    ArregloCliente = new ClienteBanco[TamArreglo];
    JOptionPane.showMessageDialog(null,"ARREGLO CREADO CON ÉXITO");
}
public static void AgregarCliente(){
   int NumCuenta;
   String NumCed;
   String Nombre;
   double Capital;
   int TipoCuenta;
   if (TamArreglo !=0 && Cont < TamArreglo) {
       NumCuenta=Integer.parseInt(JOptionPane.showInputDialog(null,"digite cuenta: "));
       NumCed=JOptionPane.showInputDialog(null,"digite cédula: ");
       Nombre=JOptionPane.showInputDialog(null,"digite nombre del cliente: ");
       Capital=Double.parseDouble(JOptionPane.showInputDialog(null,"digite valor inicial: "));
       TipoCuenta=Integer.parseInt(JOptionPane.showInputDialog(null,"Tipo cuenta 1=Ahorro 2=Corriente: "));
       ArregloCliente[Cont]=new ClienteBanco(NumCuenta,NumCed,Nombre,Capital,TipoCuenta);
       ++Cont;
       JOptionPane.showMessageDialog(null,"Cliente agregado con éxito");
   }
   else{
       JOptionPane.showMessageDialog(null,"No ha ingresado a la opción 1");
   }
   
   
}
public static void VerClientes(){

    OrdenarCuentas();

    for(int i=0;i<Cont;i++){
        String tipo;
       
        if(ArregloCliente[i].getTipoCuenta()==1){
    tipo="Ahorro";
}else{
    tipo="Corriente";
}
        JOptionPane.showMessageDialog(null,
        "Número de cuenta: " + ArregloCliente[i].getNumCuenta() +
        "\n Cédula: " + ArregloCliente[i].getNumCed() +
        "\n Cliente: " + ArregloCliente[i].getNombre() +
        "\n Capital: " + ArregloCliente[i].getCapital() +
        "\n Tipo cuenta: " + ArregloCliente[i].getTipoCuenta());
    }
}
public static void BuscarClienteCedula(){
    String ced;
    boolean encontrado=false;

    ced = JOptionPane.showInputDialog(null,"Digite la cédula a buscar");

    for(int i=0;i<Cont;i++){
if(ArregloCliente[i].getNumCed().equals(ced)){

    String tipo;

    if(ArregloCliente[i].getTipoCuenta()==1){
        tipo="Ahorro";
    }else{
        tipo="Corriente";
    }

    JOptionPane.showMessageDialog(null,
    "Número de cuenta: " + ArregloCliente[i].getNumCuenta() +
    "\n Cédula: " + ArregloCliente[i].getNumCed() +
    "\n Cliente: " + ArregloCliente[i].getNombre() +
    "\n Capital: " + ArregloCliente[i].getCapital() +
    "\n Tipo cuenta: " + tipo);
}
    }

    if(!encontrado){
        JOptionPane.showMessageDialog(null,"Cliente no encontrado");
    }
}
public static void EliminarCliente(){
    int cuenta;
    boolean encontrado=false;

    cuenta=Integer.parseInt(JOptionPane.showInputDialog(null,"Digite número de cuenta a eliminar"));

    for(int i=0;i<Cont;i++){
        if(ArregloCliente[i].getNumCuenta()==cuenta){

            for(int j=i;j<Cont-1;j++){
                ArregloCliente[j]=ArregloCliente[j+1];
            }

            Cont--;
            encontrado=true;

            JOptionPane.showMessageDialog(null,"Cliente eliminado");
            break;
        }
    }

    if(!encontrado){
        JOptionPane.showMessageDialog(null,"Cuenta no encontrada");
    }
}
public static void OrdenarCuentas(){

    ClienteBanco aux;

    for(int i=0;i<Cont-1;i++){
        for(int j=i+1;j<Cont;j++){

            if(ArregloCliente[i].getNumCuenta() > ArregloCliente[j].getNumCuenta()){

                aux = ArregloCliente[i];
                ArregloCliente[i] = ArregloCliente[j];
                ArregloCliente[j] = aux;

            }
        }
    }
}
public static void MostrarCuentasAhorro() {
    int contadorAhorros = 0;

    if (Cont == 0) {
        JOptionPane.showMessageDialog(null, "No hay clientes registrados");
        return;
    }

    for (int i = 0; i < Cont; i++) {
        if (ArregloCliente[i].getTipoCuenta() == 1) {

            JOptionPane.showMessageDialog(null,
                "Número de cuenta: " + ArregloCliente[i].getNumCuenta() +
                "\n Cédula: " + ArregloCliente[i].getNumCed() +
                "\n Cliente: " + ArregloCliente[i].getNombre() +
                "\n Capital: " + ArregloCliente[i].getCapital() +
                "\n Tipo cuenta: AHORRO");

            contadorAhorros++;
        }
    }

    JOptionPane.showMessageDialog(null, 
        "Total de clientes con cuenta de ahorro: " + contadorAhorros);
}
public static void main(String[] args) {
       int opc;
       do{
           opc=Integer.parseInt(JOptionPane.showInputDialog(null, """
Menu Principal
1. Crear Arreglo
2. Agregar Cliente
3. Ver Clientes
4. Buscar Cliente por Cédula
5. Eliminar Cliente por Cuenta
6. Ordenar por Número de Cuenta
7. MostrarCuentasAhorro
8. Salir
"""));
         switch(opc) {

case 1:
    TamañoArreglo();
    break;

case 2:
    AgregarCliente();
    break;

case 3:
    VerClientes();
    break;

case 4:
    BuscarClienteCedula();
    break;

case 5:
    EliminarCliente();
    break;

case 6:
    OrdenarCuentas();
    break;

case 7:
    MostrarCuentasAhorro();
    break; 
    
case 8:
    System.exit(0);
    break;

default:
    JOptionPane.showMessageDialog(null,"Opcion no valida");

}
           
       }while(opc!=8);
   }
}