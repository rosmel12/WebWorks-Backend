package com.upc.webworksbackend.serviceinterface;

import com.upc.webworksbackend.dto.SubscriptionDbo;
import com.upc.webworksbackend.dtoaux.SubscriptionCheck;
import com.upc.webworksbackend.dtoaux.SubscriptionSummaryDto;
import com.upc.webworksbackend.model.*;
import com.upc.webworksbackend.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SubscriptionService {

final SubscriptionRepository subscriptionRepository;
final PlanRepository planRepository;
final UserRepository userRepository;
final MethodPaymentRepository methodPaymentRepository;
final PromotionCodeRepository promotionCodeRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, PlanRepository planRepository, UserRepository userRepository, MethodPaymentRepository methodPaymentRepository, PromotionCodeRepository promotionCodeRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.planRepository = planRepository;
        this.userRepository = userRepository;
        this.methodPaymentRepository = methodPaymentRepository;
        this.promotionCodeRepository = promotionCodeRepository;
    }

    public Boolean addSubscription(SubscriptionDbo subscriptionDbo) {
        PlanModel planModel=planRepository.findById(subscriptionDbo.getId_plan()).orElse(null);
        UserModel userModel = userRepository.findById(subscriptionDbo.getId_plan()).orElse(null);
        MethodPaymentModel methodPaymentModel=methodPaymentRepository.findById(subscriptionDbo.getId_methodPayment()).orElse(null);
        PromotionCodeModel promotionCodeModel=promotionCodeRepository.findById(subscriptionDbo.getId_promotionCode()).orElse(null);
        if (planModel!=null && userModel !=null) {
            ModelMapper modelMapper = new ModelMapper();
            SubscriptionModel subscriptionModel = modelMapper.map(subscriptionDbo, SubscriptionModel.class);
            subscriptionModel.setPlanSubscription(planModel);
            subscriptionModel.setUserSubscription(userModel);
            subscriptionModel.setMethodPaymentSubscription(methodPaymentModel);
            subscriptionModel.setSubscriptionPromotionCode(promotionCodeModel);
            subscriptionRepository.save(subscriptionModel);
            return true;
        }
        return false;
    }


    public SubscriptionCheck SubscriptionActive(Integer id){
        List<SubscriptionModel> check=subscriptionRepository.SubscriptionsActivate( id, new Date());
        SubscriptionCheck subscriptionCheck=new SubscriptionCheck();
        if(!check.isEmpty()) {
            for (SubscriptionModel subscriptionModel : check) {
                if (subscriptionModel.getAmountTotal() == 0) {
                    subscriptionCheck.setAmount(subscriptionModel.getAmountTotal());
                } else {
                    subscriptionCheck.setStatus(true);
                    subscriptionCheck.setAmount(subscriptionModel.getAmountTotal());
                }
            }
        }
        return subscriptionCheck;
    }

    public List<SubscriptionSummaryDto> listSubscriptionsByUser(Integer id) {
        List<SubscriptionModel> subscriptions = subscriptionRepository.findSubscriptionModelByUserSubscription_Id(id);
        List<SubscriptionSummaryDto> subscriptionSummaryDtos = new ArrayList<>();
        if(!subscriptions.isEmpty()){
            for (SubscriptionModel subscription : subscriptions) {
                SubscriptionSummaryDto subscriptionSummaryDto = new SubscriptionSummaryDto();

                if (subscription.getSubscriptionPromotionCode()!=null) {
                    PromotionCodeModel promotionCodeModel =promotionCodeRepository.findById(subscription.getSubscriptionPromotionCode().getId()).orElse(null);
                    assert promotionCodeModel != null;
                    subscriptionSummaryDto.setNamePromotionCode(promotionCodeModel.getCode());
                    subscriptionSummaryDto.setDiscountPercentage(promotionCodeModel.getDiscountPercentage());
                }
                if (subscription.getPlanSubscription() != null) {
                    subscriptionSummaryDto.setDateStart(subscription.getDateStart());
                    subscriptionSummaryDto.setDateEnd(subscription.getDateEnd());
                    subscriptionSummaryDto.setAmountTotal(subscription.getAmountTotal());
                    subscriptionSummaryDto.setNamePlan(subscription.getPlanSubscription().getName());
                    subscriptionSummaryDtos.add(subscriptionSummaryDto);
                }
                if(subscription.getMethodPaymentSubscription() != null){
                    subscriptionSummaryDto.setNumberMethodPayment(subscription.getMethodPaymentSubscription().getNumberCard());
                }else{
                    subscriptionSummaryDto.setNumberMethodPayment("");
                }
            }
        }

        return subscriptionSummaryDtos;
    }

}
