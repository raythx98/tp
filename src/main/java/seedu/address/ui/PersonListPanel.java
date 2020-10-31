package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.information.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    public static final String TAB_NAME = "Candidates";
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    private MainWindow mainWindow;

    @FXML
    private ListView<Person> personListView;

    @FXML
    private StackPane detailedView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(ObservableList<Person> personList, MainWindow mainWindow) {
        super(FXML);
        personListView.setItems(personList);
        //personListView.setCellFactory(listView -> new PersonListViewCell());
        personListView.setCellFactory(listView -> new PersonListPanel.PersonListViewCell(mainWindow));
    };

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Person> {

        private MainWindow mainWindow;

        public PersonListViewCell(MainWindow mainWindow) {
            this.mainWindow = mainWindow;
        }
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCard(person, getIndex() + 1).getRoot());
                setOnMouseClicked(event -> mainWindow.updateDetailedPersonPanel(person));
            }
        }

    }
}
