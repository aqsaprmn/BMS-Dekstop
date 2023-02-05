package BookHenry;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
import Model.Author;
import Model.Books;
import Model.Branch;
import Model.Inventory;
import Model.Publisher;
import Model.Wrote;
import com.mysql.cj.xdevapi.Result;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.*;
import javafx.collections.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author aqsha.permana
 */
public class Controller implements Initializable {

    @FXML
    private AnchorPane Layout;

    @FXML
    private Button deleteAu;

    @FXML
    private Button deleteBo;

    @FXML
    private Button deleteBr;

    @FXML
    private Button deleteInv;

    @FXML
    private Button deletePub;

    @FXML
    private Button deleteWr;

    @FXML
    private Button insertAu;

    @FXML
    private Button insertBo;

    @FXML
    private Button insertBr;

    @FXML
    private Button insertInv;

    @FXML
    private Button insertPub;

    @FXML
    private Button insertWr;

    @FXML
    private TextField textAuFirst;

    @FXML
    private TextField textAuLast;

    @FXML
    private TextField textAuNum;

    @FXML
    private TextField textBoCode;

    @FXML
    private TextField textBoPaper;

    @FXML
    private TextField textBoPrice;

    @FXML
    private TextField textBoPubCode;

    @FXML
    private TextField textBoTitle;

    @FXML
    private TextField textBoType;

    @FXML
    private TextField textBrEmployees;

    @FXML
    private TextField textBrLocation;

    @FXML
    private TextField textBrName;

    @FXML
    private TextField textBrNum;

    @FXML
    private TextField textInvBoCode;

    @FXML
    private TextField textInvBrNum;

    @FXML
    private TextField textInvOnHand;

    @FXML
    private TextField textPubCity;

    @FXML
    private TextField textPubCode;

    @FXML
    private TextField textPubName;

    @FXML
    private TextField textWrAuNum;

    @FXML
    private TextField textWrBoCode;

    @FXML
    private TextField textWrSequence;

    @FXML
    private Button updateAu;

    @FXML
    private Button updateBo;

    @FXML
    private Button updateBr;

    @FXML
    private Button updateInv;

    @FXML
    private Button updatePub;

    @FXML
    private Button updateWr;

    @FXML
    private Button resetPub;

    @FXML
    private Button resetBr;

    @FXML
    private Button resetAu;

    @FXML
    private Button resetBo;

    @FXML
    private Button resetInv;

    @FXML
    private Button resetWr;

    @FXML
    private TableColumn<Inventory, String> colInvBoCode;

    @FXML
    private TableColumn<Inventory, String> colInvBrNum;

    @FXML
    private TableColumn<Inventory, String> colInvOnHand;

    @FXML
    private TableView<Inventory> tableInventory;

    @FXML
    private TableView<Branch> tableBranch;

    @FXML
    private TableColumn<Branch, String> colBrLocation;

    @FXML
    private TableColumn<Branch, String> colBrName;

    @FXML
    private TableColumn<Branch, String> colBrNum;

    @FXML
    private TableColumn<Branch, String> colBrNumEm;

    @FXML
    private TableView<Books> tableBook;

    @FXML
    private TableColumn<Books, String> colBoCode;

    @FXML
    private TableColumn<Books, String> colBoPaperBack;

    @FXML
    private TableColumn<Books, String> colBoPubCode;

    @FXML
    private TableColumn<Books, String> colBoPrice;

    @FXML
    private TableColumn<Books, String> colBoType;

    @FXML
    private TableColumn<Books, String> colBoTitle;

    @FXML
    private TableView<Publisher> tablePublisher;

    @FXML
    private TableColumn<Publisher, String> colPubCity;

    @FXML
    private TableColumn<Publisher, String> colPubCode;

    @FXML
    private TableColumn<Publisher, String> colPubName;

    @FXML
    private TableView<Author> tableAuthor;

    @FXML
    private TableColumn<Author, String> colAuFirst;

    @FXML
    private TableColumn<Author, String> colAuLast;

    @FXML
    private TableColumn<Author, String> colAuNum;

    @FXML
    private TableView<Wrote> tableWrote;

    @FXML
    private TableColumn<Wrote, String> colWrBo;

    @FXML
    private TableColumn<Wrote, String> ColWrAuNum;

    @FXML
    private TableColumn<Wrote, String> ColWrSquence;

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;

    @FXML
    void handleButtonAction(ActionEvent event) {
        Button sourceButton = (Button) event.getSource();
        if (sourceButton == insertPub) {
            insert("Publisher");
            reset("Publisher");
            showPublisher();
            validasiData("Publisher");
        } else if (sourceButton == resetPub) {
            reset("Publisher");
            validasiData("Publisher");
        } else if (sourceButton == updatePub) {
            update("Publisher");
            reset("Publisher");
            showPublisher();
            validasiData("Publisher");
        } else if (sourceButton == deletePub) {
            delete("Publisher");
            reset("Publisher");
            showPublisher();
            validasiData("Publisher");
        } else if (sourceButton == insertBr) {
            insert("Branch");
            reset("Branch");
            showBranch();
            validasiData("Branch");
        } else if (sourceButton == resetBr) {
            reset("Branch");
            validasiData("Branch");
        } else if (sourceButton == updateBr) {
            update("Branch");
            reset("Branch");
            showBranch();
            validasiData("Branch");
        } else if (sourceButton == deleteBr) {
            delete("Branch");
            reset("Branch");
            showBranch();
            validasiData("Branch");
        } else if (sourceButton == insertAu) {
            insert("Author");
            reset("Author");
            showAuthor();
            validasiData("Author");
        } else if (sourceButton == resetAu) {
            reset("Author");
            validasiData("Author");
        } else if (sourceButton == updateAu) {
            update("Author");
            reset("Author");
            showAuthor();
            validasiData("Author");
        } else if (sourceButton == deleteAu) {
            delete("Author");
            reset("Author");
            showAuthor();
            validasiData("Author");
        } else if (sourceButton == insertBo) {
            insert("Books");
            reset("Books");
            showBook();
            validasiData("Books");
        } else if (sourceButton == resetBo) {
            reset("Books");
            validasiData("Books");
        } else if (sourceButton == updateBo) {
            update("Books");
            reset("Books");
            showBook();
            validasiData("Books");
        } else if (sourceButton == deleteBo) {
            delete("Books");
            reset("Books");
            showBook();
            validasiData("Books");
        } else if (sourceButton == insertInv) {
            insert("Inventory");
            reset("Inventory");
            showInventory();
            validasiData("Inventory");
        } else if (sourceButton == resetInv) {
            reset("Inventory");
            validasiData("Inventory");
        } else if (sourceButton == updateInv) {
            update("Inventory");
            reset("Inventory");
            showInventory();
            validasiData("Inventory");
        } else if (sourceButton == deleteInv) {
            delete("Inventory");
            reset("Inventory");
            showInventory();
            validasiData("Inventory");
        } else if (sourceButton == insertWr) {
            insert("Wrote");
            reset("Wrote");
            showWrote();
            validasiData("Wrote");
        } else if (sourceButton == resetWr) {
            reset("Wrote");
            validasiData("Wrote");
        } else if (sourceButton == updateWr) {
            update("Wrote");
            reset("Wrote");
            showWrote();
            validasiData("Wrote");
        } else if (sourceButton == deleteWr) {
            delete("Wrote");
            reset("Wrote");
            showWrote();
            validasiData("Wrote");
        }

    }

    @FXML
    void handleInput(KeyEvent event) {

        TextField sourceTextField = (TextField) event.getSource();

        if (sourceTextField == textPubCode) {
            System.out.println(textPubCode.getText());
            String PubCode = textPubCode.getText();

            if (PubCode == "" || PubCode.equals("")) {
                validasiData("Publisher");
            } else if (PubCode != "" || !PubCode.equals("")) {
                openData("Publisher");
            }
        } else if (sourceTextField == textBoCode) {
            System.out.println(textBoCode.getText());
            String BoCode = textBoCode.getText();

            if (BoCode == "" || BoCode.equals("")) {
                validasiData("Books");
            } else if (BoCode != "" || !BoCode.equals("")) {
                openData("Books");
            }
        } else if (sourceTextField == textBrNum) {
            System.out.println(textBrNum.getText());
            String BrNum = textBrNum.getText();

            if (BrNum == "" || BrNum.equals("")) {
                validasiData("Branch");
            } else if (BrNum != "" || !BrNum.equals("")) {
                openData("Branch");
            }
        } else if (sourceTextField == textAuNum) {
            System.out.println(textAuNum.getText());
            String AuNum = textAuNum.getText();

            if (AuNum == "" || AuNum.equals("")) {
                validasiData("Author");
            } else if (AuNum != "" || !AuNum.equals("")) {
                openData("Author");
            }
        } else if (sourceTextField == textWrBoCode) {
            System.out.println(textWrBoCode.getText());
            String WrBoCode = textWrBoCode.getText();

            if (WrBoCode == "" || WrBoCode.equals("")) {
                validasiData("Wrote");
            } else if (WrBoCode != "" || !WrBoCode.equals("")) {
                openData("Wrote");
            }
        } else if (sourceTextField == textInvBoCode) {
            System.out.println(textInvBoCode.getText());
            String InvBoCode = textInvBoCode.getText();

            if (InvBoCode == "" || InvBoCode.equals("")) {
                validasiData("Inventory");
            } else if (InvBoCode != "" || !InvBoCode.equals("")) {
                openData("Inventory");
            }
        }
    }

    public void validasiData(String modul) {
        if (modul == "Publisher") {
            textPubName.setDisable(true);
            textPubCity.setDisable(true);
            insertPub.setDisable(true);
            deletePub.setDisable(true);
            updatePub.setDisable(true);
            resetPub.setDisable(true);
        } else if (modul == "Books") {
            textBoTitle.setDisable(true);
            textBoPubCode.setDisable(true);
            textBoType.setDisable(true);
            textBoPrice.setDisable(true);
            textBoPaper.setDisable(true);
            insertBo.setDisable(true);
            deleteBo.setDisable(true);
            updateBo.setDisable(true);
            resetBo.setDisable(true);
        } else if (modul == "Branch") {
            textBrName.setDisable(true);
            textBrLocation.setDisable(true);
            textBrEmployees.setDisable(true);
            insertBr.setDisable(true);
            deleteBr.setDisable(true);
            updateBr.setDisable(true);
            resetBr.setDisable(true);
        } else if (modul == "Author") {
            textAuLast.setDisable(true);
            textAuFirst.setDisable(true);
            insertAu.setDisable(true);
            deleteAu.setDisable(true);
            updateAu.setDisable(true);
            resetAu.setDisable(true);
        } else if (modul == "Wrote") {
            textWrAuNum.setDisable(true);
            textWrSequence.setDisable(true);
            insertWr.setDisable(true);
            deleteWr.setDisable(true);
            updateWr.setDisable(true);
            resetWr.setDisable(true);
        } else if (modul == "Inventory") {
            textInvBrNum.setDisable(true);
            textInvOnHand.setDisable(true);
            insertInv.setDisable(true);
            deleteInv.setDisable(true);
            updateInv.setDisable(true);
            resetInv.setDisable(true);
        }
    }

    public void openData(String modul) {
        if (modul == "Publisher") {
            textPubName.setDisable(false);
            textPubCity.setDisable(false);
            insertPub.setDisable(false);
            deletePub.setDisable(false);
            updatePub.setDisable(false);
            resetPub.setDisable(false);
        } else if (modul == "Books") {
            textBoTitle.setDisable(false);
            textBoPubCode.setDisable(false);
            textBoType.setDisable(false);
            textBoPrice.setDisable(false);
            textBoPaper.setDisable(false);
            insertBo.setDisable(false);
            deleteBo.setDisable(false);
            updateBo.setDisable(false);
            resetBo.setDisable(false);
        } else if (modul == "Branch") {
            textBrName.setDisable(false);
            textBrLocation.setDisable(false);
            textBrEmployees.setDisable(false);
            insertBr.setDisable(false);
            deleteBr.setDisable(false);
            updateBr.setDisable(false);
            resetBr.setDisable(false);
        } else if (modul == "Author") {
            textAuLast.setDisable(false);
            textAuFirst.setDisable(false);
            insertAu.setDisable(false);
            deleteAu.setDisable(false);
            updateAu.setDisable(false);
            resetAu.setDisable(false);
        } else if (modul == "Wrote") {
            textWrAuNum.setDisable(false);
            textWrSequence.setDisable(false);
            insertWr.setDisable(false);
            deleteWr.setDisable(false);
            updateWr.setDisable(false);
            resetWr.setDisable(false);
        } else if (modul == "Inventory") {
            textInvBrNum.setDisable(false);
            textInvOnHand.setDisable(false);
            insertInv.setDisable(false);
            deleteInv.setDisable(false);
            updateInv.setDisable(false);
            resetInv.setDisable(false);
        }
    }

    @FXML
    void handleGetEditData(MouseEvent event) {

        TableView sourceTableView = (TableView) event.getSource();

        if (sourceTableView == tablePublisher) {
            Publisher publisher = tablePublisher.getSelectionModel().getSelectedItem();
            textPubCode.setText(publisher.getPublisherCode());
            textPubName.setText(publisher.getPublisherName());
            textPubCity.setText(publisher.getCity());
            openData("Publisher");
        } else if (sourceTableView == tableBranch) {
            Branch branch = tableBranch.getSelectionModel().getSelectedItem();
            textBrNum.setText(branch.getBranchNum() + "");
            textBrName.setText(branch.getBranchName());
            textBrLocation.setText(branch.getBranchLocation());
            textBrEmployees.setText(branch.getNumEmployess() + "");
            openData("Branch");
        } else if (sourceTableView == tableAuthor) {
            Author author = tableAuthor.getSelectionModel().getSelectedItem();
            textAuNum.setText(author.getAuthorNum() + "");
            textAuLast.setText(author.getAuthorLast());
            textAuFirst.setText(author.getAuthorFirst());
            openData("Author");
        } else if (sourceTableView == tableBook) {
            Books books = tableBook.getSelectionModel().getSelectedItem();
            textBoCode.setText(books.getBookCode());
            textBoTitle.setText(books.getTitle());
            textBoPubCode.setText(books.getPublisherCode());
            textBoType.setText(books.getType());
            textBoPrice.setText(String.valueOf(books.getPrice()));
            textBoPaper.setText(books.getPaperback());
            openData("Books");
        } else if (sourceTableView == tableInventory) {
            Inventory inventory = tableInventory.getSelectionModel().getSelectedItem();
            textInvBoCode.setText(inventory.getBookCode());
            textInvBrNum.setText(inventory.getBranchNum() + "");
            textInvOnHand.setText(inventory.getOnHand() + "");
            openData("Inventory");
        } else if (sourceTableView == tableWrote) {
            Wrote wrote = tableWrote.getSelectionModel().getSelectedItem();
            textWrBoCode.setText(wrote.getBookCode());
            textWrAuNum.setText(wrote.getAuthorNum() + "");
            textWrSequence.setText(wrote.getSquence() + "");
            openData("Wrote");

        }
    }

    ObservableList<Inventory> listInventory;
    ObservableList<Publisher> listPublisher;
    ObservableList<Branch> listBranch;
    ObservableList<Books> listBooks;
    ObservableList<Author> listAuthor;
    ObservableList<Wrote> listWrote;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBranch();
        showPublisher();
        showBook();
        showAuthor();
        showInventory();
        showWrote();

//        System.out.println(textPubCode);
//        String PubCode = textPubCode.getText();
//        if (PubCode != "" || !PubCode.equals("")){
//            openData("Publisher");
//        }
        validasiData("Publisher");
        validasiData("Books");
        validasiData("Branch");
        validasiData("Author");
        validasiData("Wrote");
        validasiData("Inventory");

    }

    public void showInventory() {
        colInvBoCode.setCellValueFactory(new PropertyValueFactory<Inventory, String>("bookCode"));
        colInvBrNum.setCellValueFactory(new PropertyValueFactory<Inventory, String>("branchNum"));
        colInvOnHand.setCellValueFactory(new PropertyValueFactory<Inventory, String>("onHand"));

        listInventory = DBConnect.getDataInventory();
        tableInventory.setItems(listInventory);
    }

    public void showBranch() {
        colBrNum.setCellValueFactory(new PropertyValueFactory<Branch, String>("BranchNum"));
        colBrName.setCellValueFactory(new PropertyValueFactory<Branch, String>("BranchName"));
        colBrLocation.setCellValueFactory(new PropertyValueFactory<Branch, String>("BranchLocation"));
        colBrNumEm.setCellValueFactory(new PropertyValueFactory<Branch, String>("NumEmployess"));

        listBranch = DBConnect.getDataBranch();
        tableBranch.setItems(listBranch);
    }

    public void showPublisher() {
        colPubCode.setCellValueFactory(new PropertyValueFactory<Publisher, String>("PublisherCode"));
        colPubName.setCellValueFactory(new PropertyValueFactory<Publisher, String>("PublisherName"));
        colPubCity.setCellValueFactory(new PropertyValueFactory<Publisher, String>("City"));

        listPublisher = DBConnect.getDataPublisher();
        tablePublisher.setItems(listPublisher);
    }

    public void showBook() {
        colBoCode.setCellValueFactory(new PropertyValueFactory<Books, String>("BookCode"));
        colBoTitle.setCellValueFactory(new PropertyValueFactory<Books, String>("Title"));
        colBoPubCode.setCellValueFactory(new PropertyValueFactory<Books, String>("PublisherCode"));
        colBoType.setCellValueFactory(new PropertyValueFactory<Books, String>("Type"));
        colBoPrice.setCellValueFactory(new PropertyValueFactory<Books, String>("Price"));
        colBoPaperBack.setCellValueFactory(new PropertyValueFactory<Books, String>("Paperback"));

        listBooks = DBConnect.getDataBooks();
        tableBook.setItems(listBooks);
    }

    public void showAuthor() {
        colAuNum.setCellValueFactory(new PropertyValueFactory<Author, String>("AuthorNum"));
        colAuLast.setCellValueFactory(new PropertyValueFactory<Author, String>("AuthorLast"));
        colAuFirst.setCellValueFactory(new PropertyValueFactory<Author, String>("AuthorFirst"));

        listAuthor = DBConnect.getDataAuthor();
        tableAuthor.setItems(listAuthor);
    }

    public void showWrote() {
        colWrBo.setCellValueFactory(new PropertyValueFactory<Wrote, String>("BookCode"));
        ColWrAuNum.setCellValueFactory(new PropertyValueFactory<Wrote, String>("AuthorNum"));
        ColWrSquence.setCellValueFactory(new PropertyValueFactory<Wrote, String>("Squence"));
        listWrote = DBConnect.getDataWrote();
        tableWrote.setItems(listWrote);
    }

    public void reset(String title) {
        if (title == "Publisher") {
            textPubCode.setText("");
            textPubName.setText("");
            textPubCity.setText("");
        } else if (title == "Branch") {
            textBrNum.setText("");
            textBrName.setText("");
            textBrLocation.setText("");
            textBrEmployees.setText("");
        } else if (title == "Books") {
            textBoCode.setText("");
            textBoTitle.setText("");
            textBoPubCode.setText("");
            textBoType.setText("");
            textBoPrice.setText("");
            textBoPaper.setText("");
        } else if (title == "Author") {
            textAuNum.setText("");
            textAuLast.setText("");
            textAuFirst.setText("");
        } else if (title == "Inventory") {
            textInvBoCode.setText("");
            textInvBrNum.setText("");
            textInvOnHand.setText("");
        } else if (title == "Wrote") {
            textWrBoCode.setText("");
            textWrAuNum.setText("");
            textWrSequence.setText("");
        }
    }

    public void insert(String title) {

        conn = DBConnect.getConnection();
        if (title == "Publisher") {
            String query = "INSERT INTO publisher (PublisherCode , PublisherName , City) VALUES (?,?,?)";
            try {
                ps = conn.prepareStatement(query);
                ps.setString(1, textPubCode.getText());
                ps.setString(2, textPubName.getText());
                ps.setString(3, textPubCity.getText());
                ps.execute();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Insert Publiser");
                alert.setContentText("Insert Publiser Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("INSERT Publiser");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Branch") {
            conn = DBConnect.getConnection();
            String query = "INSERT INTO branch (BranchNum , BranchName , BranchLocation , NumEmployess) VALUES (?,?,?,?)";
            try {
                ps = conn.prepareStatement(query);
                ps.setString(1, textBrNum.getText());
                ps.setString(2, textBrName.getText());
                ps.setString(3, textBrLocation.getText());
                ps.setString(4, textBrEmployees.getText());
                ps.execute();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Insert Branch");
                alert.setContentText("Insert Branch Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("INSERT Branch");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }

        } else if (title == "Author") {
            conn = DBConnect.getConnection();
            String query = "INSERT INTO author (AuthorNum , AuthorLast , AuthorFirst) VALUES (?,?,?)";
            try {
                ps = conn.prepareStatement(query);
                ps.setString(1, textAuNum.getText());
                ps.setString(2, textAuLast.getText());
                ps.setString(3, textAuFirst.getText());
                ps.execute();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Insert Author");
                alert.setContentText("Insert Author Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("INSERT Author");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }

        } else if (title == "Books") {
            conn = DBConnect.getConnection();
            String query = "INSERT INTO book (BookCode , Title , PublisherCode , Type , Price , Paperback) VALUES (?,?,?,?,?,?)";
            try {
                ps = conn.prepareStatement(query);
                ps.setString(1, textBoCode.getText());
                ps.setString(2, textBoTitle.getText());
                ps.setString(3, textBoPubCode.getText());
                ps.setString(4, textBoType.getText());
                ps.setString(5, textBoPrice.getText());
                ps.setString(6, textBoPaper.getText());
                ps.execute();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Insert Book");
                alert.setContentText("Insert Book Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("INSERT Book");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }

        } else if (title == "Inventory") {
            conn = DBConnect.getConnection();
            String query = "INSERT INTO inventory (BookCode , BranchNum , OnHand) VALUES (?,?,?)";
            try {
                ps = conn.prepareStatement(query);
                ps.setString(1, textInvBoCode.getText());
                ps.setString(2, textInvBrNum.getText());
                ps.setString(3, textInvOnHand.getText());
                ps.execute();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Insert Inventory");
                alert.setContentText("Insert Inventory Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("INSERT Inventory");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }

        } else if (title == "Wrote") {
            conn = DBConnect.getConnection();
            String query = "INSERT INTO wrote (BookCode , AutorNum , Squence) VALUES (?,?,?)";
            try {
                ps = conn.prepareStatement(query);
                ps.setString(1, textWrBoCode.getText());
                ps.setString(2, textWrAuNum.getText());
                ps.setString(3, textWrSequence.getText());
                ps.execute();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Insert Wrote");
                alert.setContentText("Insert Wrote Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("INSERT Wrote");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }

        }
    }

    public void update(String title) {
        conn = DBConnect.getConnection();
        if (title == "Publisher") {
            try {
                String query = "UPDATE publisher SET PublisherCode = '" + textPubCode.getText()
                        + "' , PublisherName = '" + textPubName.getText()
                        + "' , City = '" + textPubCity.getText()
                        + "' WHERE PublisherCode = '" + textPubCode.getText() + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Update Publisher");
                alert.setContentText("Update Publisher : " + textPubCode.getText() + ", Success!");
                alert.showAndWait();

            } catch (SQLException ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Update Publisher");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Branch") {
            try {
                String query = "UPDATE branch SET BranchNum = '" + Integer.parseInt(textBrNum.getText())
                        + "' , BranchName = '" + textBrName.getText()
                        + "' , BranchLocation = '" + textBrLocation.getText()
                        + "' , NumEmployess = '" + textBrEmployees.getText()
                        + "' WHERE BranchNum = '" + Integer.parseInt(textBrNum.getText()) + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Update Branch");
                alert.setContentText("Update Branch : " + textBrNum.getText() + ", Success!");
                alert.showAndWait();

            } catch (SQLException ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Update Branch");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Author") {
            try {
                String query = "UPDATE author SET AuthorNum = '" + Integer.parseInt(textAuNum.getText())
                        + "' , AuthorLast = '" + textAuLast.getText()
                        + "' , AuthorFirst = '" + textAuFirst.getText()
                        + "' WHERE AuthorNum = '" + Integer.parseInt(textAuNum.getText()) + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Update Author");
                alert.setContentText("Update Author : " + textAuNum.getText() + ", Success!");
                alert.showAndWait();

            } catch (SQLException ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Update Author");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Books") {
            try {
                String query = "UPDATE book SET BookCode = '" + textBoCode.getText()
                        + "' , Title = '" + textBoTitle.getText()
                        + "' , PublisherCode = '" + textBoPubCode.getText()
                        + "' , Type = '" + textBoType.getText()
                        + "' , Price = '" + textBoPrice.getText()
                        + "' , Paperback = '" + textBoPaper.getText()
                        + "' WHERE BookCode = '" + textBoCode.getText() + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Update Book");
                alert.setContentText("Update Book : " + textBoCode.getText() + ", Success!");
                alert.showAndWait();

            } catch (SQLException ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Update Book");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Inventory") {
            try {
                String query = "UPDATE inventory SET BookCode = '" + textInvBoCode.getText()
                        + "' , BranchNum = '" + textInvBrNum.getText()
                        + "' , OnHand = '" + textInvOnHand.getText()
                        + "' WHERE BookCode = '" + Integer.parseInt(textInvBoCode.getText()) + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Update Inventory");
                alert.setContentText("Update Inventory : " + textInvBoCode.getText() + ", Success!");
                alert.showAndWait();

            } catch (SQLException ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Update Inventory");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Wrote") {
            try {
                String query = "UPDATE wrote SET BookCode = '" + textWrBoCode.getText()
                        + "' , AutorNum = '" + textWrAuNum.getText()
                        + "' , Squence = '" + textWrSequence.getText()
                        + "' WHERE BookCode = '" + Integer.parseInt(textWrBoCode.getText()) + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Update Wrote");
                alert.setContentText("Update Wrote : " + textWrBoCode.getText() + ", Success!");
                alert.showAndWait();

            } catch (SQLException ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Update Wrote");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        }
    }

    public void delete(String title) {
        conn = DBConnect.getConnection();
        if (title == "Publisher") {
            try {
                String query = "DELETE FROM publisher WHERE PublisherCode = '"
                        + textPubCode.getText() + "' AND PublisherName = '"
                        + textPubName.getText() + "' AND City = '"
                        + textPubCity.getText() + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Delete Publisher");
                alert.setContentText("Delete Publisher : " + textPubCode.getText() + ", Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Delete Publisher");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Branch") {
            try {
                String query = "DELETE FROM branch WHERE BranchNum = '"
                        + textBrNum.getText() + "' AND BranchName = '"
                        + textBrName.getText() + "' AND BranchLocation = '"
                        + textBrLocation.getText() + "' AND NumEmployess = '"
                        + textBrEmployees.getText() + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Delete Branch");
                alert.setContentText("Delete Branch : " + textBrNum.getText() + ", Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Delete Branch");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Author") {
            try {
                String query = "DELETE FROM author WHERE AuthorNum = '"
                        + textAuNum.getText() + "' AND AuthorLast = '"
                        + textAuLast.getText() + "' AND AuthorFirst = '"
                        + textAuFirst.getText() + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Delete Author");
                alert.setContentText("Delete Author : " + textAuNum.getText() + ", Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Delete Author");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Books") {
            try {
                String query = "DELETE FROM book WHERE BookCode = '"
                        + textBoCode.getText() + "' AND Title = '"
                        + textBoTitle.getText() + "' AND PublisherCode = '"
                        + textBoPubCode.getText() + "' AND Type = '"
                        + textBoType.getText() + "' AND Price = '"
                        + textBoPrice.getText() + "' AND Paperback = '"
                        + textBoPaper.getText() + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Delete Book");
                alert.setContentText("Delete Book : " + textBoCode.getText() + ", Success!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Delete Book");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Inventory") {
            try {
                String query = "DELETE FROM inventory WHERE BookCode = '"
                        + textInvBoCode.getText() + "' AND BranchNum = '"
                        + textInvBrNum.getText() + "' AND OnHand = '"
                        + textInvOnHand.getText() + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Delete Inventory");
                alert.setContentText("Delete Inventory : " + textInvBoCode.getText() + ", Success!");
                alert.showAndWait();
            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Delete Inventory");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        } else if (title == "Wrote") {
            try {
                String query = "DELETE FROM wrote WHERE BookCode = '"
                        + textWrBoCode.getText() + "' AND AutorNum = '"
                        + textWrAuNum.getText() + "' AND Squence = '"
                        + textWrSequence.getText() + "'";
                ps = conn.prepareStatement(query);
                ps.executeUpdate();
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Delete Wrote");
                alert.setContentText("Delete Wrote : " + textWrBoCode.getText() + ", Succses!");
                alert.showAndWait();

            } catch (Exception ex) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Failed");
                alert.setHeaderText("Delete Wrote");
                alert.setContentText(ex + "");
                alert.showAndWait();
            }
        }
    }

}
