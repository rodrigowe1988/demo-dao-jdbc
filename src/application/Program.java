package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== TEST 1: seller findById ====\n");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller + "\n");

        System.out.println("=== TEST 2: seller findByDepartment ====\n");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartament(department);
        for (Seller obj: list) {
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 3: seller findAll sort by name ASC ====\n");
        list = sellerDao.findAll();
        for (Seller obj: list) {
            System.out.println(obj);
        }

        /*
        System.out.println("\n=== TEST 4: seller INSERT ====\n");
        Seller newSeller = new Seller(null, "Greg Blue", "greg@gmail", new Date(), 4000.00, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
        */

        System.out.println("\n=== TEST 5: seller UPDATE ====\n");
        seller = sellerDao.findById(4);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update completed!");

        System.out.println("\n=== TEST 6: seller DELETE ====\n");
        System.out.println("Enter the id of seller you want to delete: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.printf("Seller with id = %d was deleted!\n", id);

        sc.close();
    }
}