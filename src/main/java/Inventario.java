package Model;

public class Inventario {
    private int id;
    private String descripcion;
    private int id_marca;
    private double precio_compra;
    private double precio_venta;
    private int stock;
    private int id_subcategoria;
	private boolean estado;
    
    public Inventario() {
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdMarca() {
        return id_marca;
    }

    public void setIdMarca(int id_marca) {
        this.id_marca = id_marca;
    }

    public double getPrecioCompra() {
        return precio_compra;
    }

    public void setPrecioCompra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecioVenta() {
        return precio_venta;
    }

    public void setPrecioVenta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getIdSubcategoria() {
        return id_subcategoria;
    }

    public void setIdSubcategoria(int id_subcategoria) {
        this.id_subcategoria = id_subcategoria;
    }
    
}