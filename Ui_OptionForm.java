/********************************************************************************
 ** Form generated from reading ui file 'Option.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_OptionForm implements com.trolltech.qt.QUiForm<QWidget>
{
    public static boolean first = true;
    public QWidget layoutWidget;
    public QVBoxLayout verticalLayout_3;
    public QHBoxLayout horizontalLayout_3;
    public QVBoxLayout verticalLayout_2;
    public QHBoxLayout horizontalLayout_2;
    public QLabel label;
    public QSpacerItem horizontalSpacer;
    public QSpacerItem horizontalSpacer_2;
    public static QCheckBox checkBox;
    public QSpacerItem verticalSpacer;
    public QVBoxLayout verticalLayout;
    public QLabel label_2;
    public QHBoxLayout horizontalLayout;
    public static QRadioButton Green_yellow;
    public static QRadioButton White_dark;
    public QSpacerItem verticalSpacer_2;
    public QHBoxLayout horizontalLayout_4;
    public QDialogButtonBox buttonBox;
    public QSpacerItem horizontalSpacer_3;

    public Ui_OptionForm() { super(); }

    public void setupUi(QWidget Form)
    {
        Form.setObjectName("Form");
        Form.resize(new QSize(269, 231).expandedTo(Form.minimumSizeHint()));
        layoutWidget = new QWidget(Form);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(30, 30, 213, 171));
        verticalLayout_3 = new QVBoxLayout(layoutWidget);
        verticalLayout_3.setObjectName("verticalLayout_3");
        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3.setObjectName("horizontalLayout_3");
        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2.setObjectName("verticalLayout_2");
        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        label = new QLabel(layoutWidget);
        label.setObjectName("label");

        horizontalLayout_2.addWidget(label);

        horizontalSpacer = new QSpacerItem(68, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_2.addItem(horizontalSpacer);


        verticalLayout_2.addLayout(horizontalLayout_2);


        horizontalLayout_3.addLayout(verticalLayout_2);

        horizontalSpacer_2 = new QSpacerItem(48, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_3.addItem(horizontalSpacer_2);


        verticalLayout_3.addLayout(horizontalLayout_3);

        if(first) {
            checkBox = new QCheckBox(layoutWidget);
            checkBox.click();

        }
        checkBox.setObjectName("checkBox");

        verticalLayout_3.addWidget(checkBox);

        verticalSpacer = new QSpacerItem(20, 18, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        verticalLayout_3.addItem(verticalSpacer);

        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        label_2 = new QLabel(layoutWidget);
        label_2.setObjectName("label_2");

        verticalLayout.addWidget(label_2);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        if(first) {
            Green_yellow = new QRadioButton(layoutWidget);
            Green_yellow.setEnabled(true);
            Green_yellow.setAcceptDrops(false);
        }
        Green_yellow.setObjectName("Green_Red");

        horizontalLayout.addWidget(Green_yellow);

        if(first) {
            White_dark = new QRadioButton(layoutWidget);
            White_dark.setMouseTracking(true);
            White_dark.click();
        }
        White_dark.setObjectName("White_dark");

        horizontalLayout.addWidget(White_dark);


        verticalLayout.addLayout(horizontalLayout);


        verticalLayout_3.addLayout(verticalLayout);

        verticalSpacer_2 = new QSpacerItem(20, 13, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        verticalLayout_3.addItem(verticalSpacer_2);

        horizontalLayout_4 = new QHBoxLayout();
        horizontalLayout_4.setObjectName("horizontalLayout_4");

        buttonBox = new QDialogButtonBox(layoutWidget);
        buttonBox.setStandardButtons(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.createQFlags(com.trolltech.qt.gui.QDialogButtonBox.StandardButton.Ok));

        buttonBox.setObjectName("buttonBox");

        horizontalLayout_4.addWidget(buttonBox);

        horizontalSpacer_3 = new QSpacerItem(128, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout_4.addItem(horizontalSpacer_3);


        verticalLayout_3.addLayout(horizontalLayout_4);

        retranslateUi(Form);
        first =false;
       // checkBox.clicked.connect(this, "vis()");
        //checkBox.isChecked();

        buttonBox.clicked.connect(Form, "close()");

        Form.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget Form)
    {
        Form.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Form", "Настройки", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u041d\u0430\u0441\u0442\u0440\u043e\u0439\u043a\u0438:", null));
        checkBox.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "С визуализацией", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u0420\u0430\u0441\u043a\u0440\u0430\u0441\u043a\u0430 \u0433\u0440\u0430\u0444\u043e\u0432 \u043f\u0440\u0438 \u0432\u0438\u0437\u0443\u0430\u043b\u0438\u0437\u0430\u0446\u0438\u0438:", null));
        Green_yellow.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "Жёлто-зелёный", null));
        White_dark.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u0427\u0435\u0440\u043d\u043e-\u0431\u0435\u043b\u0430\u044f", null));
    } // retranslateUi

    /*void vis()
    {
        visualisation = !visualisation;
    }*/

}

