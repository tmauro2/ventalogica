import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int cantidadVentas;
        int ventasMayores = 0;
        int ventasMenores = 0;
        int clientesVIP = 0;

        double totalVentas = 0;
        double ventaMayor = 0;
        double ventaMenor = 0;

        System.out.print("Ingrese la cantidad de ventas: ");
        cantidadVentas = entrada.nextInt();

        for (int i = 1; i <= cantidadVentas; i++) {

            System.out.println("\nVenta #" + i);
            System.out.print("Ingrese el valor de la venta: ");
            double venta = entrada.nextDouble();

            totalVentas += venta;

            if (venta > 1000000) {
                System.out.println("Nivel 1: Cliente VIP.");
                clientesVIP++;
            } else if (venta >= 500000) {
                System.out.println("Nivel 2: Cliente Frecuente.");
                ventasMayores++;
            } else {
                System.out.println("Nivel 3: Cliente General.");
                ventasMenores++;
            }

            if (venta > ventaMayor) {
                ventaMayor = venta;
            }

            // Condicional doble: detectar venta menor
            if (i == 1) {
                ventaMenor = venta;
            } else if (venta < ventaMenor) {
                ventaMenor = venta;
            }
        }

        double promedio = totalVentas / cantidadVentas;

        System.out.println("\n================ INFORME EMPRESARIAL ================");
        System.out.println("Cantidad de ventas: " + cantidadVentas);
        System.out.println("Total recaudado: $" + totalVentas);
        System.out.println("Promedio de ventas: $" + promedio);
        System.out.println("Venta más alta: $" + ventaMayor);
        System.out.println("Venta más baja: $" + ventaMenor);
        System.out.println("Ventas Nivel 1 (> $1.000.000): " + clientesVIP);
        System.out.println("Ventas Nivel 2 (entre $500.000 y $1.000.000): " + ventasMayores);
        System.out.println("Ventas Nivel 3 (< $500.000): " + ventasMenores);

        entrada.close();
    }
}