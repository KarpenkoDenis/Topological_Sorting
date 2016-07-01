/********************************************************************************
 ** Form generated from reading ui file 'AddFileForm.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/



/********************************************************************************
 ** Form generated from reading ui file 'AddFileForm.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_AddFileForm implements com.trolltech.qt.QUiForm<QWidget>
{
    public QWidget widget;
    public QVBoxLayout verticalLayout_3;
    public QVBoxLayout verticalLayout_2;
    public QVBoxLayout verticalLayout;
    public QHBoxLayout horizontalLayout;
    public QLabel label;
    public QSpacerItem horizontalSpacer;
    public QLineEdit lineEdit;
    public QHBoxLayout horizontalLayout_2;
    public QPushButton Ok;
    public QPushButton Cansel;
    public static String inputString;

    public Ui_AddFileForm() { super(); }

    public void setupUi(QWidget Form)
    {
        Form.setObjectName("Form");
        Form.resize(new QSize(236, 87).expandedTo(Form.minimumSizeHint()));
        widget = new QWidget(Form);
        widget.setObjectName("widget");
        widget.setGeometry(new QRect(0, 0, 234, 85));
        verticalLayout_3 = new QVBoxLayout(widget);
        verticalLayout_3.setObjectName("verticalLayout_3");
        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2.setObjectName("verticalLayout_2");
        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        label = new QLabel(widget);
        label.setObjectName("label");

        horizontalLayout.addWidget(label);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer);


        verticalLayout.addLayout(horizontalLayout);

        lineEdit = new QLineEdit(widget);
        lineEdit.setObjectName("lineEdit");

        verticalLayout.addWidget(lineEdit);


        verticalLayout_2.addLayout(verticalLayout);


        verticalLayout_3.addLayout(verticalLayout_2);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        Ok = new QPushButton(widget);
        Ok.setObjectName("Ok");

        horizontalLayout_2.addWidget(Ok);

        Cansel = new QPushButton(widget);
        Cansel.setObjectName("Cansel");

        horizontalLayout_2.addWidget(Cansel);


        verticalLayout_3.addLayout(horizontalLayout_2);

        retranslateUi(Form);

        if(lineEdit.isModified())
        {
            lineEdit.text();
        }
        Cansel.clicked.connect(Form, "close()");
        //if(Ok.clicked.)inputString = lineEdit.text();
        Ok.clicked.connect(this, "read_line()");
        Ok.clicked.connect(Form, "close()");

        Form.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget Form)
    {
        Form.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Form", "Form", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Form","Введите имя файла( без расширения)" /*"\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043f\u0443\u0442\u044c \u043a \u0442\u0435\u043a\u0441\u0442\u043e\u0432\u043e\u043c\u0443 \u0444\u0430\u0439\u043b\u0443:"*/, null));
        Ok.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u041e\u043a", null));
        Cansel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u041e\u0442\u043c\u0435\u043d\u0430", null));
    } // retranslateUi
    void read_line()
    {
        inputString = lineEdit.text();
    }

}

