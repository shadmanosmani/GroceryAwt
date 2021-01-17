package awt.grocery.frame.service;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;

import awt.grocery.entity.ProductEntity;

public class FrameServiceImpl {

	public static final String SANS_SERIF_FONT = "SansSerif";

	float totalAmount = 0.0f;

	public Frame getStartFrame() {

		Frame frame = new Frame("Products");

		Label productNameHeaderLabel = new Label("Product Name", Label.LEFT);
		productNameHeaderLabel.setFont(new Font(SANS_SERIF_FONT, Font.BOLD, 18));

		Label priceHeaderLabel = new Label("Price (in Rs.)", Label.CENTER);
		priceHeaderLabel.setFont(new Font(SANS_SERIF_FONT, Font.BOLD, 18));

		Label selectQuantityHeaderLabel = new Label("Select Quantity", Label.CENTER);
		selectQuantityHeaderLabel.setFont(new Font(SANS_SERIF_FONT, Font.BOLD, 18));

		Panel bodyPanel = new Panel();

		bodyPanel.add(productNameHeaderLabel);
		bodyPanel.add(priceHeaderLabel);
		bodyPanel.add(selectQuantityHeaderLabel);

		Set<ProductEntity> productList = new HashSet<>();

		productList.add(new ProductEntity(1L, "Colgate", 10.0f, 0));
		productList.add(new ProductEntity(2L, "Noodles", 15.0f, 0));
		productList.add(new ProductEntity(3L, "Butter", 50.0f, 0));
		productList.add(new ProductEntity(4L, "Sauce", 70.0f, 0));
		productList.add(new ProductEntity(5L, "Coffee", 80.0f, 0));

		Set<ProductDAO> productElements = new HashSet<>();

		productList.forEach(product -> {

			ProductDAO productElement = new ProductDAO();

			Label productNameLabel = new Label(product.getName(), Label.LEFT);
			productNameLabel.setFont(new Font(SANS_SERIF_FONT, Font.PLAIN, 18));
			productElement.setProductNameLabel(productNameLabel);

			Label priceLabel = new Label(String.valueOf(product.getPrice()), Label.CENTER);
			priceLabel.setFont(new Font(SANS_SERIF_FONT, Font.PLAIN, 18));
			productElement.setPriceLabel(priceLabel);

			TextField selectQuantityTextField = new TextField(String.valueOf(product.getSelectedQuantity()), 10);
			selectQuantityTextField.setFont(new Font(SANS_SERIF_FONT, Font.PLAIN, 18));
			productElement.setSelectQuantityTextField(selectQuantityTextField);

			bodyPanel.add(productNameLabel);
			bodyPanel.add(priceLabel);
			bodyPanel.add(selectQuantityTextField);
			productElements.add(productElement);

		});

		bodyPanel.setLayout(new GridLayout(productList.size() + 1, 3));

		frame.add(bodyPanel);

		Label total = new Label("", Label.LEFT);
		total.setFont(new Font(SANS_SERIF_FONT, Font.BOLD, 18));

		frame.add(total);

		Button placeOrderButton = new Button("Place Order");

		frame.add(getFooterPanel(placeOrderButton));

		frame.setLayout(new FlowLayout());

		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}

		});

		placeOrderButton.addActionListener(placeOrderButtonListener -> {

			totalAmount = 0.0f;

			productElements.forEach(product -> {

				totalAmount += Float.valueOf(product.getPriceLabel().getText())
						* Float.valueOf(product.getSelectQuantityTextField().getText());

			});

			total.setText("Your total is: Rs. " + totalAmount);

		});

		frame.setSize(600, 400);
		frame.setVisible(true);

		return frame;
	}

	public Panel getFooterPanel(Button placeOrderButton) {

		Panel footerPanel = new Panel();
		placeOrderButton.setFont(new Font(SANS_SERIF_FONT, Font.BOLD, 16));

		footerPanel.add(placeOrderButton);

		return footerPanel;

	}

	public static class ProductDAO {

		private Label productNameLabel;

		private Label priceLabel;

		private TextField selectQuantityTextField;

		public ProductDAO() {
			super();
		}

		public ProductDAO(Label productNameLabel, Label priceLabel, TextField selectQuantityTextField) {
			super();
			this.productNameLabel = productNameLabel;
			this.priceLabel = priceLabel;
			this.selectQuantityTextField = selectQuantityTextField;
		}

		public Label getProductNameLabel() {
			return productNameLabel;
		}

		public void setProductNameLabel(Label productNameLabel) {
			this.productNameLabel = productNameLabel;
		}

		public Label getPriceLabel() {
			return priceLabel;
		}

		public void setPriceLabel(Label priceLabel) {
			this.priceLabel = priceLabel;
		}

		public TextField getSelectQuantityTextField() {
			return selectQuantityTextField;
		}

		public void setSelectQuantityTextField(TextField selectQuantityTextField) {
			this.selectQuantityTextField = selectQuantityTextField;
		}

	}

}
