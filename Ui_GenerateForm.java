/********************************************************************************
 ** Form generated from reading ui file 'generate_form.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_GenerateForm implements com.trolltech.qt.QUiForm<QWidget>
{
    public QWidget layoutWidget;
    public QVBoxLayout verticalLayout;
    public QLabel label;
    public QLabel label_5;
    public QHBoxLayout horizontalLayout_3;
    public QLabel label_2;
    public QSlider count_of_top;
    public QLabel label_4;
    public QLabel label_6;
    public QHBoxLayout horizontalLayout_2;
    public QLabel label_3;
    public QSlider count_of_edges;
    public QLabel label_7;
    public QCheckBox without_cycle;
    public QCheckBox round_painting;
    public QHBoxLayout horizontalLayout;
    public QPushButton Ok;
    public QPushButton Cansel;

    public Ui_GenerateForm() { super(); }

    public void setupUi(QWidget Form)
    {
        Form.setObjectName("Form");
        Form.resize(new QSize(241, 200).expandedTo(Form.minimumSizeHint()));
        layoutWidget = new QWidget(Form);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(20, 0, 201, 190));
        verticalLayout = new QVBoxLayout(layoutWidget);
        verticalLayout.setObjectName("verticalLayout");
        label = new QLabel(layoutWidget);
        label.setObjectName("label");

        verticalLayout.addWidget(label);

        label_5 = new QLabel(layoutWidget);
        label_5.setObjectName("label_5");

        verticalLayout.addWidget(label_5);

        horizontalLayout_3 = new QHBoxLayout();
        horizontalLayout_3.setObjectName("horizontalLayout_3");
        label_2 = new QLabel(layoutWidget);
        label_2.setObjectName("label_2");

        horizontalLayout_3.addWidget(label_2);

        count_of_top = new QSlider(layoutWidget);
        count_of_top.setObjectName("count_of_top");
        count_of_top.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        count_of_top.setMaximum(50);
        count_of_top.setValue(10);

        horizontalLayout_3.addWidget(count_of_top);

        label_4 = new QLabel(layoutWidget);
        label_4.setObjectName("label_4");

        horizontalLayout_3.addWidget(label_4);


        verticalLayout.addLayout(horizontalLayout_3);

        label_6 = new QLabel(layoutWidget);
        label_6.setObjectName("label_6");

        verticalLayout.addWidget(label_6);

        horizontalLayout_2 = new QHBoxLayout();
        horizontalLayout_2.setObjectName("horizontalLayout_2");
        label_3 = new QLabel(layoutWidget);
        label_3.setObjectName("label_3");

        horizontalLayout_2.addWidget(label_3);

        count_of_edges = new QSlider(layoutWidget);
        count_of_edges.setObjectName("count_of_edges");
        count_of_edges.setOrientation(com.trolltech.qt.core.Qt.Orientation.Horizontal);
        count_of_edges.setMaximum(50);
        count_of_edges.setValue(10);

        horizontalLayout_2.addWidget(count_of_edges);

        label_7 = new QLabel(layoutWidget);
        label_7.setObjectName("label_7");

        horizontalLayout_2.addWidget(label_7);


        verticalLayout.addLayout(horizontalLayout_2);

        without_cycle = new QCheckBox(layoutWidget);
        without_cycle.setObjectName("without_cycle");

        verticalLayout.addWidget(without_cycle);

        round_painting = new QCheckBox(layoutWidget);
        round_painting.setObjectName("round_painting");

        verticalLayout.addWidget(round_painting);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        Ok = new QPushButton(layoutWidget);
        Ok.setObjectName("Ok");

        horizontalLayout.addWidget(Ok);

        Cansel = new QPushButton(layoutWidget);
        Cansel.setObjectName("Cansel");

        horizontalLayout.addWidget(Cansel);


        verticalLayout.addLayout(horizontalLayout);

        retranslateUi(Form);

        //
        count_of_edges.valueChanged.connect(this, "setCountOfTop()");
        count_of_top.valueChanged.connect(this, "setCountOfEdges()");
        Cansel.clicked.connect(Form, "close()");
        //if(Ok.clicked.)inputString = lineEdit.text();
        Ok.clicked.connect(Form, "close()");
        //
        
        Form.connectSlotsByName();
    } // setupUi
    private void setCountOfTop()
    {
        if( count_of_top.value() < count_of_edges.value() )
        {
            count_of_top.setValue(count_of_edges.value());
        }

    }
    private void setCountOfEdges()
    {

        if( count_of_top.value() < count_of_edges.value() )
        {
            count_of_edges.setValue(count_of_top.value());
        }
        // count_of_top.setValue(curr_value +1);

    }
    void retranslateUi(QWidget Form)
    {
        Form.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Form", "Form", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u0420\u0430\u0437\u043c\u0435\u0440 \u0433\u0440\u0430\u0444\u0430:", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0432\u0435\u0440\u0448\u0438\u043d:", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "0", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "50", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u041a\u043e\u043b\u0438\u0447\u0435\u0441\u0442\u0432\u043e \u0440\u0451\u0431\u0435\u0440:", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "0", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "50", null));
        without_cycle.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u0413\u0440\u0430\u0444 \u0441\u043e\u0437\u0434\u0430\u0451\u0442\u0441\u044f \u0431\u0435\u0437 \u0446\u0438\u043a\u043b\u043e\u0432", null));
        round_painting.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u0413\u0440\u0430\u0444 \u0440\u0438\u0441\u0443\u0435\u0442\u0441\u044f \u043f\u043e \u043a\u0440\u0443\u0433\u0443", null));
        Ok.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u041e\u043a", null));
        Cansel.setText(com.trolltech.qt.core.QCoreApplication.translate("Form", "\u041e\u0442\u043c\u0435\u043d\u0430", null));
    } // retranslateUi

}

