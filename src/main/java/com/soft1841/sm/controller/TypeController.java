package com.soft1841.sm.controller;


import com.soft1841.sm.entity.Type;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.utils.ComponentUtil;

import com.soft1841.sm.utils.ServiceFactory;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * 类别管理界面
 * @author 杨晶
 * 2018-12-26
 */


public class TypeController implements Initializable {
    //获得布局文件中的表格对象
    @FXML
    private TableView<Type> typeTable;

    //定义ObservableList数据集合
    private ObservableList<Type> typeData = FXCollections.observableArrayList();

    //通过工厂类获得Service的实例
    private TypeService typeService  = ServiceFactory.getTypeServiceInstance();

    //定义实体集合，用来存放数据库查询结果
    private List<Type> typeList;

    private TableColumn<Type, Type> delCol = new TableColumn<>("备注");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //水平方向不显示滚动条
        typeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        //在表格最后加入删除按钮
        delCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        delCol.setCellFactory(param -> new TableCell<Type, Type>() {
            private final Button deleteButton = ComponentUtil.getButton("删除", "warning-theme");
            @Override
            protected void updateItem(Type type, boolean empty) {
                super.updateItem(type, empty);
                if (type == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(deleteButton);
                //点击删除按钮，需要将这一行从表格移除，同时从底层数据库真正删除
                deleteButton.setOnAction(event -> {
                    //删除操作之前，弹出确认对话框，点击确认按钮才删除
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("确认对话框");
                    alert.setHeaderText("请确认");
                    alert.setContentText("确定要删除这行记录吗?");
                    Optional<ButtonType> result = alert.showAndWait();
                    //点击了确认按钮，执行删除操作，同时移除一行模型数据
                    if (result.get() == ButtonType.OK) {
                        typeData.remove(type);
                        //调用typeService的删除类别方法
                        typeService.deleteType(type.getId());
                    }
                });
            }
        });
        //删除列加入表格
        typeTable.getColumns().add(delCol);
        typeList = typeService.getAllTypes();
        showTypeData(typeList);
    }



    private void showTypeData(List<Type> typeList) {
        typeData.addAll(typeList);
        typeTable.setItems(typeData);
    }


}
