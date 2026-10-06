public class Fecha {
    private int mes;
    private int dia;
    private int año;

    public Fecha(int mes, int dia, int año) {
        this.mes = mes;
        this.dia = dia;
        this.año = año;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getMes() {
        return mes;
    }

    public int getDia() {
        return dia;
    }

    public int getAño() {
        return año;
    }

    public void mostrarFecha() {
        System.out.println(mes + "/" + dia + "/" + año);
    }
}