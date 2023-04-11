package pojos;

public class Prenda {
    
    private int idPrenda;
    private int idCategoria;
    private int piezas;
    private String serie;
    private double porcentajePrestamo;
    private int idSubCategoria;
    private String descripcion;
    private double prestamo;
    private String modelo;
    private double avaluo;

    public Prenda() {
    }

    public Prenda(int idPrenda, int idCategoria, int piezas, String serie, double porcentajePrestamo, int idSubCategoria, String descripcion, double prestamo, String modelo, double avaluo) {
        this.idPrenda = idPrenda;
        this.idCategoria = idCategoria;
        this.piezas = piezas;
        this.serie = serie;
        this.porcentajePrestamo = porcentajePrestamo;
        this.idSubCategoria = idSubCategoria;
        this.descripcion = descripcion;
        this.prestamo = prestamo;
        this.modelo = modelo;
        this.avaluo = avaluo;
    }

    
    
    public int getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public double getPorcentajePrestamo() {
        return porcentajePrestamo;
    }

    public void setPorcentajePrestamo(double porcentajePrestamo) {
        this.porcentajePrestamo = porcentajePrestamo;
    }

    public int getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(double prestamo) {
        this.prestamo = prestamo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getAvaluo() {
        return avaluo;
    }

    public void setAvaluo(double avaluo) {
        this.avaluo = avaluo;
    }
          
    
    
}
