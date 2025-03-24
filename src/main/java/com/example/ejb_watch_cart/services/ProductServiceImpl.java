package com.example.ejb_watch_cart.services;

import com.example.ejb_watch_cart.models.Product;
import jakarta.ejb.Local;
import jakarta.ejb.Stateful;

import java.util.ArrayList;
import java.util.List;


@Stateful
public class ProductServiceImpl implements ProductService {
    List<Product> products = new ArrayList<>();

    public ProductServiceImpl() {
        products.add(Product.builder().id(43).name("Citizen 40 mm Nam AW1780-84L")
                .mainImage("citizen-aw1780-84l-nam-1.jpg").price(7085000.0).build());
        products.add(Product.builder().id(42).name("Casio 37.6 mm Nữ LWS-2200H-4AVDF")
                .mainImage("casio-lws-2200h-4avdf-nu-1.jpg").price(1677000.0).build());
        products.add(Product.builder().id(45).name("CITIZEN 30.5 mm Nữ EM0896-89Y")
                .mainImage("citizen-em0896-89y-nu-1.jpg").price(7185000.0).build());
        products.add(Product.builder().id(46).name("Rolex Cosmograph Daytona 40 116503-0004")
                .mainImage("dong-ho-rolex-cosmograph-daytona-40-116503-0004-mat-so-den-day-oyster-thep-vang-vang-4.jpg")
                .price(656250000.0).build());
        products.add(Product.builder().id(44).name("CITIZEN 32 mm Nữ EM0508-80Y")
                .mainImage("citizen-em0508-80y-nu-1.jpeg").price(7485000.0).build());
        products.add(Product.builder().id(51).name("Orient Bambino 41.5 mm Nam RA-AK0801S10B")
                .mainImage("orient-ra-ak0801s10b-nam-1.jpg").price(11360000.0).build());
        products.add(Product.builder().id(50).name("ORIENT Bambino 36.4 mm Nữ RA-AC0008S10B")
                .mainImage("orient-ra-ac0008s10b-nu-1-2.jpg").price(9700000.0).build());
        products.add(Product.builder().id(52).name("Orient Bambino 41.5 mm Nam RA-AK0802S10B")
                .mainImage("orient-ra-ak0802s10b-nam-1.jpg").price(10790000.0).build());
        products.add(Product.builder().id(47)
                .name("Rolex Cosmograph Daytona 40 116506-0001 Mặt Số Ice-Blue Dây Oyster Thép")
                .mainImage("dong-ho-rolex-cosmograph-daytona-40-116506-0001-mat-so-xanh-bang-day-oyster-thep-3.jpg")
                .price(2215000000.0).build());
        products.add(Product.builder().id(55).name("CERTINA Urban 39 mm Nam C035.407.36.087.00")
                .mainImage("certina-c035-407-36-087-00-nam-1-org.jpg").price(18720000.0).build());
        products.add(Product.builder().id(54).name("Nakzen 32 mm Nữ SS8335L-1NR")
                .mainImage("nakzen-ss8335l-1nr-nu-1.jpg").price(1360000.0).build());
        products.add(Product.builder().id(48).name("Rolex Cosmograph Daytona 40 116508-0013 Mặt Số Xanh Lá Dây Oyster")
                .mainImage("dong-ho-rolex-cosmograph-daytona-40-116508-0013-mat-so-xanh-la-day-oyster-7.jpg")
                .price(1105086600.0).build());
        products.add(Product.builder().id(57).name("Nakzen Hoa & Gió 40 mm Nam SS9470G-6")
                .mainImage("nakzen-ss9470g-6-nam-1.jpg").price(1820000.0).build());
        products.add(Product.builder().id(56).name("CERTINA Urban 32 mm Nữ C033.257.36.118.00")
                .mainImage("certina-c033-257-36-118-00-nu1-org.jpg").price(15110000.0).build());
        products.add(Product.builder().id(49)
                .name("Rolex Datejust 31 278274-0035 Mặt Số Hoạ Tiết Hoa Azzurro Màu Xanh Dương Dây Đeo Oyster Thép")
                .mainImage("dong-ho-rolex-datejust-31-278274-0035-mat-so-hoa-tiet-hoa-azzurro-mau-xanh-duong-day-deo-oyster-thep-7.jpg")
                .price(296336400.0).build());
        products.add(Product.builder().id(40).name("Casio 34 mm Nam MTP-M305D-1AVDF")
                .mainImage("casio-mtp-m305d-1avdf-nam-1.jpg").price(3767000.0).build());
        products.add(Product.builder().id(53).name("CERTINA Urban 31 mm Nữ C035.207.22.037.02")
                .mainImage("certina-c035-207-22-037-02-nu1-org.jpg").price(19700000.0).build());
        products.add(Product.builder().id(41).name("CASIO 45 x 42.1 mm Nam AE-1200WHD-1AVDF")
                .mainImage("casio-ae-1200whd-1avdf-bac-up-1-org.jpg").price(1506000.0).build());

    }

    @Override
    public List<Product> listProducts() {
        return products;
    }

    @Override
    public Product getProduct(int id) {
        return products
                .stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        Product existingProduct = products
                .stream()
                .filter(p -> p.getId() == product.getId())
                .findFirst()
                .orElse(null);

        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
        }
    }

    @Override
    public void removeProduct(int id) {
        products.removeIf(product -> product.getId() == id);
    }
}
