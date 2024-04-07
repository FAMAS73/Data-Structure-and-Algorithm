import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryManagementSystemGUI extends JFrame {
    private Map<String, Product> inventoryMap = new HashMap<>();
    private List<Product> productList = new ArrayList<>();

    private JTable tblProduct;
    private DefaultTableModel tableModel;

    private JTextField txtProductCode;
    private JTextField txtProductName;
    private JTextField txtQuantity;

    public InventoryManagementSystemGUI() {
        setTitle("Inventory Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create JTable with the name tblProduct
        tableModel = new DefaultTableModel(new Object[]{"Product Code", "Product Name", "Quantity"}, 0);
        tblProduct = new JTable(tableModel);

        // Add JTable to JScrollPane
        JScrollPane scrollPane = new JScrollPane(tblProduct);
        add(scrollPane, BorderLayout.CENTER);

        // Add panel for input fields and buttons
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        add(inputPanel, BorderLayout.SOUTH);

        txtProductCode = new JTextField();
        txtProductName = new JTextField();
        txtQuantity = new JTextField();

        inputPanel.add(new JLabel("Product Code:"));
        inputPanel.add(txtProductCode);
        inputPanel.add(new JLabel("Product Name:"));
        inputPanel.add(txtProductName);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(txtQuantity);

        JButton addButton = new JButton("Add Product");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProduct();
            }
        });

        JButton editButton = new JButton("Edit Product");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editProduct();
            }
        });

        JButton deleteButton = new JButton("Delete Product");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteProduct();
            }
        });

        JButton purchaseButton = new JButton("Purchase");
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                purchaseProduct();
            }
        });

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchProduct();
            }
        });

        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);
        inputPanel.add(purchaseButton);
        inputPanel.add(searchButton);

        setSize(500, 300);
        setLocationRelativeTo(null);
    }

    private void addProduct() {
        String productCode = txtProductCode.getText();
        String productName = txtProductName.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());

        if (!inventoryMap.containsKey(productCode)) {
            inventoryMap.put(productCode, new Product(productCode, productName, quantity));
            productList.add(new Product(productCode, productName, quantity));
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Product with code " + productCode + " already exists.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editProduct() {
        String productCode = txtProductCode.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());

        if (inventoryMap.containsKey(productCode)) {
            Product product = inventoryMap.get(productCode);
            product.setQuantity(quantity);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Product with code " + productCode + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteProduct() {
        String productCode = txtProductCode.getText();

        if (inventoryMap.containsKey(productCode)) {
            inventoryMap.remove(productCode);
            productList.removeIf(product -> product.getProductId().equals(productCode));
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Product with code " + productCode + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void purchaseProduct() {
        String productCode = txtProductCode.getText();
        int quantity = Integer.parseInt(txtQuantity.getText());

        if (inventoryMap.containsKey(productCode)) {
            Product product = inventoryMap.get(productCode);
            product.setQuantity(product.getQuantity() + quantity);
            updateTable();
        } else {
            JOptionPane.showMessageDialog(this, "Product with code " + productCode + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchProduct() {
        String productCode = txtProductCode.getText();

        if (inventoryMap.containsKey(productCode)) {
            Product product = inventoryMap.get(productCode);
            txtProductName.setText(product.getProductName());
            txtQuantity.setText(String.valueOf(product.getQuantity()));
        } else {
            JOptionPane.showMessageDialog(this, "Product with code " + productCode + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateTable() {
        // Clear existing rows in the table
        tableModel.setRowCount(0);

        // Add updated data from productList to DefaultTableModel
        for (Product product : productList) {
            tableModel.addRow(new Object[]{product.getProductId(), product.getProductName(), product.getQuantity()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InventoryManagementSystemGUI().setVisible(true);
        });
    }
}

class Product {
    private String productId;
    private String productName;
    private int quantity;

    public Product(String productId, String productName, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
