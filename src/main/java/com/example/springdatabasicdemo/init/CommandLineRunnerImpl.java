package com.example.springdatabasicdemo.init;

import com.example.springdatabasicdemo.dtos.*;
import com.example.springdatabasicdemo.models.enums.Category;
import com.example.springdatabasicdemo.models.enums.Engine;
import com.example.springdatabasicdemo.models.enums.UserRoleEnum;
import com.example.springdatabasicdemo.models.enums.Transmission;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.springdatabasicdemo.services.*;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private BrandService brandService;
    private ModelService modelService;
    private OfferService offerService;
    private UserRoleService userRoleService;
    private UserService userService;

    public CommandLineRunnerImpl(BrandService brandService, ModelService modelService, OfferService offerService, UserRoleService userRoleService, UserService userService) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.offerService = offerService;
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        runService();
    }

    private void seedData() throws IOException {
        // Создаем и добавляем объекты для сущности Brand
        BrandDTO brand1 = new BrandDTO(0, new Date(2003,5,6), new Date(2004,6,6), "Brand1");
        BrandDTO brand2 = new BrandDTO(0, new Date(1999,9,9), new Date(2001,1,1), "Brand2");
        brandService.createBrand(brand1);
        brandService.createBrand(brand2);

        Optional<BrandDTO> brandFirstOp = brandService.findBrand(1);
        Optional<BrandDTO> brandSecondOp = brandService.findBrand(2);

        BrandDTO brandFirst = brandFirstOp.get();
        BrandDTO brandSecond = brandSecondOp.get();

        // Создаем и добавляем объекты для сущности Model
        ModelDTO model1 = new ModelDTO(0, new Date(1998,5,5), new Date(2003,5,9), Category.Buss, 2022, "model1.jpg", "Model1", 2020, brandFirst);
        ModelDTO model2 = new ModelDTO(0, new Date(1999,2,3), new Date(2005,6,7), Category.Motorcycle, 2023, "model2.jpg", "Model2", 2021, brandSecond);
        modelService.createModel(model1);
        modelService.createModel(model2);

        Optional<ModelDTO> modelFirstOp = modelService.findModel(1);
        Optional<ModelDTO> modelSecondOp = modelService.findModel(2);

        ModelDTO modelFirst = modelFirstOp.get();
        ModelDTO modelSecond = modelSecondOp.get();

        // Создаем и добавляем объекты для сущности UserRole
        UserRoleDTO userRole1 = new UserRoleDTO(0, UserRoleEnum.USER);
        UserRoleDTO userRole2 = new UserRoleDTO(0, UserRoleEnum.USER);
        userRoleService.createUserRole(userRole1);
        userRoleService.createUserRole(userRole2);

        Optional<UserRoleDTO> userRoleFirstOp = userRoleService.findUserRole(1);
        Optional<UserRoleDTO> userRoleSecondOp = userRoleService.findUserRole(2);

        UserRoleDTO userRoleFirst = userRoleFirstOp.get();
        UserRoleDTO userRoleSecond = userRoleSecondOp.get();

        // Создаем и добавляем объекты для сущности User
        UserDTO user1 = new UserDTO(0, new Date(2003,5,6), new Date(2005,6,7), userRoleFirst, true, "Наруто", "user1.jpg", "Узумаки", "123456", "Hokage#1");
        UserDTO user2 = new UserDTO(0, new Date(1999,2,3), new Date(2001,1,1), userRoleSecond, true, "Саске", "user2.jpg", "Учиха", "F1j;15", "HaterKonoha");
        userService.createUser(user1);
        userService.createUser(user2);

        Optional<UserDTO> userFirstOp = userService.findUser(1);
        Optional<UserDTO> userSecondOp = userService.findUser(2);

        UserDTO userFirst = userFirstOp.get();
        UserDTO userSecond = userSecondOp.get();

        // Создаем и добавляем объекты для сущности Offer
        OfferDTO offer1 = new OfferDTO(0, new Date(1103,5,6), new Date(2005,6,7), modelFirst, userFirst, "Offer1 Description", Engine.DIESEL, "image1.jpg", 10000, 20000.0, Transmission.AUTOMATIC, 2023);
        OfferDTO offer2 = new OfferDTO(0, new Date(1199,2,3), new Date(2001,1,1), modelSecond, userSecond, "Offer2 Description", Engine.GASOLINE, "image2.jpg", 15000, 25000.0, Transmission.MANUAL, 2022);
        offerService.createOffer(offer1);
        offerService.createOffer(offer2);

    }

    public void runService() {
        Optional<ModelDTO> modelFirstOp = modelService.findModel(1);
        ModelDTO modelFirst = modelFirstOp.get();
        List<OfferDTO> arrOffersFirst = offerService.findOffersByModel(modelFirst);
        List<OfferDTO> arrOffersSecond = offerService.findTopByMileage();
        List<UserDTO> arrUsernames = userService.findUserByUsername("user1username");
        List<ModelDTO> arrModels = modelService.findModelByName("Model1");

        for (int i = 0; i < arrOffersFirst.size(); i++) {
            System.out.println(arrOffersFirst.get(i).toString());
        }

        for (int i = 0; i < arrOffersSecond.size(); i++) {
            System.out.println(arrOffersSecond.get(i).toString());
        }

        for (int i = 0; i < arrUsernames.size(); i++) {
            System.out.println(arrUsernames.get(i).toString());
        }

        for (int i = 0; i < arrModels.size(); i++) {
            System.out.println(arrModels.get(i).toString());
        }
    }
}