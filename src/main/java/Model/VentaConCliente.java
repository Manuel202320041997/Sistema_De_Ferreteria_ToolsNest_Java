package Model;

public class VentaConCliente {
    private Venta venta;
    private Cliente cliente;

    public VentaConCliente(Venta venta, Cliente cliente) {
        this.venta = venta;
        this.cliente = cliente;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

