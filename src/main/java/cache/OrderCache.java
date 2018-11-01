package cache;

import controllers.ProductController;
import model.Order;
import model.Product;
import utils.Config;

import java.util.ArrayList;

//TODO: Build this cache and use it.
public class OrderCache {

    //List of orders
    private ArrayList<Order> orders;

    private long ttl;

    private long created;

    public OrderCache() {this.ttl= Config.getOrderTtl();}

    public ArrayList<Order> getOrders(Boolean forceUpdate) {

        if (forceUpdate
                || ((this.created + this.ttl) >= (System.currentTimeMillis() / 1000L))
                || this.orders== null) {

            // Get products from controller, since we wish to update.
            ArrayList<Product> products = ProductController.getProducts();

            //Set products for the instance and set created timestamp
            this.orders = orders;
            this.created= System.currentTimeMillis() / 1000L;
        }

        //Return the documents
        return this.orders;

    }
}
