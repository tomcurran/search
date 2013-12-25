package view;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Result;

public class ResultView extends JPanel {

	private static final long serialVersionUID = 8564824276005076581L;

	private static final String TEMPLATE_FILENAME = "<html><span style='color: blue; text-decoration: underline; font-size: 16px;'>%s</span></html>";
	private static final String TEMPLATE_FILEPATH = "<html><span style='color: green; font-size: 14px;'>%s</span></html>";
	private static final String TEMPLATE_RESULT = "<html><span style='color: #444; font-size: 13px;'>%d. %s</span></html>";
	private static final String TEMPLATE_HIGHLIGHT_START = "<span style='background-color:yellow;'>";
	private static final String TEMPLATE_HIGHLIGHT_END = "</span>";
	private static final String TOOLTIP_FILENAME = "Open file '%s'";
	private static final String TOOLTIP_FILEPATH = "Open file '%s'";
	private static final String TOOLTIP_RESULT = "Open result in file '%s'";

	private JButton fileNameView;
	private JButton filePathView;
	private List<JButton> resultsViews;
	private Result result;

	public ResultView(Result result) {
		this.result = result;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(new EmptyBorder(5, 10, 5, 10));
		createFileName();
		createFilePath();
		createResults();
	}

	private void createFileName() {
		String fileName = result.getFileName();
		fileNameView = new JButton();
		commomButton(fileNameView);
		fileNameView.setText(String.format(TEMPLATE_FILENAME, fileName));
		fileNameView.setToolTipText(String.format(TOOLTIP_FILENAME, fileName));
		add(fileNameView);
	}

	private void createFilePath() {
		String fileName = result.getFileName();
		String filePath = result.getFileDirectory();
		filePathView = new JButton();
		commomButton(filePathView);
		filePathView.setText(String.format(TEMPLATE_FILEPATH, filePath));
		filePathView.setToolTipText(String.format(TOOLTIP_FILEPATH, fileName));
		add(filePathView);
	}

	private void createResults() {
		String fileName = result.getFileName();
		List<String> results = result.getResults();
		resultsViews = new ArrayList<JButton>();
		String result;
		JButton resultView;
		for (int i = 0; i < results.size(); i++) {
			result = results.get(i);
			result = result.replace("<highlight>", TEMPLATE_HIGHLIGHT_START);
			result = result.replace("</highlight>", TEMPLATE_HIGHLIGHT_END);
			resultView = new JButton();
			commomButton(resultView);
			resultView.setText(String.format(TEMPLATE_RESULT, i + 1, result));
			resultView.setToolTipText(String.format(TOOLTIP_RESULT, fileName));
			resultView.setMargin(new Insets(0,30,0,0));
			resultsViews.add(resultView);
			add(resultView);
		}
	}

	private void commomButton(JButton button) {
		button.setMargin(new Insets(0,0,0,0));
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setBackground(Color.WHITE);
	}

	public void addOpenFileListener(ActionListener listener) {
		fileNameView.addActionListener(listener);
		filePathView.addActionListener(listener);
		for (JButton resultsView : resultsViews) {
			resultsView.addActionListener(listener);
		}
	}

}