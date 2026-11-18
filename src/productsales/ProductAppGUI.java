package productsales;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.*;

public class ProductAppGUI extends JFrame {

    // Components as required by Q2.1
    private final JComboBox<String> cmbProducts = new JComboBox<>(
            new String[]{"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"}
    );
    private final JTextField txtCustomerName = new JTextField(20);
    private final JTextField txtSelectProduct = new JTextField(20);
    private final JTextField txtPrice = new JTextField(20);
    private final JButton btnProcess = new JButton("PROCESS");

    private final ProductCalculations productCalculations = new ProductCalculations();
    private final DecimalFormat moneyFormat = new DecimalFormat("#,##0.00");

    public ProductAppGUI() {
        setTitle("Product App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        createMenu();
        createForm();
    }

    // Creates the Menu System (Q2.2 & Q2.3)
    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");

        // Action Listeners
        exitItem.addActionListener(e -> System.exit(0));
        processItem.addActionListener(e -> ProcessMessage());
        clearItem.addActionListener(e -> clearForm());

        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    private void createForm() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 5, 7, 5);
        gbc.anchor = GridBagConstraints.WEST;

        btnProcess.addActionListener(e -> ProcessProductData());

        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Customer Name:"), gbc);
        gbc.gridx = 1;
        panel.add(txtCustomerName, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Select product:"), gbc);
        gbc.gridx = 1;
        panel.add(cmbProducts, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Enter Price:"), gbc);
        gbc.gridx = 1;
        panel.add(txtPrice, gbc);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(btnProcess, gbc);

        add(panel, BorderLayout.CENTER);
    }


    private void processProductData() {
        productCalculations.getCustomerName() = (String) txtCustomerName.getSelectedItem();
        productCalculations.getProductName() = cmbProducts.get().trim();
        productCalculations.GetVat() = .getText().trim();
        productCalculations.GetCommission() = .getText().trim();
        productCalculations.getTotal() =

        double price = Double.parseDouble(priceText);
        double percentage = Double.parseDouble(percentageText);
        double commission = estateAgent.CalculateCommission(priceText, percentageText);

        ProductAppGUI.
        ProductAppGUI.
        ProductAppGUI.
        ProductAppGUI.

        String report = "Customer Name: " + txtCustomerName + "\n"
                + "Product: " + cmbProducts + "\n"
                + "VAT: R " + moneyFormat.format(price) + "\n"
                + "COMMISSION : " + moneyFormat.format(percentage) + "%\n"
                + "TOTAL: R " + moneyFormat.format(commission);

        txtReport.setText(report);
    }

    private void saveReportToFile(String reportText) {
        String fileContent =
                "************************************\n"
                + reportText + "\n"
                + "************************************";

        try (FileWriter writer = new FileWriter("report.txt")) {
            writer.write(fileContent);

            // ADD THIS POPUP to confirm the file was created!
            JOptionPane.showMessageDialog(this,
                    "Report successfully saved to report.txt!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error saving report to file: " + e.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        cmbProducts.setSelectedIndex(0);
        txtPrice.setText("");
    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductAppGUI().setVisible(true));
    }

    }
}
