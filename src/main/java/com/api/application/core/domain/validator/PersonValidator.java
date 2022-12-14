package com.api.application.core.domain.validator;

import com.api.application.core.commons.DomainReturnCode;
import com.api.application.core.domain.entity.person.Person;
import com.api.application.utils.exeption.ApplicationBusinessException;
import org.springframework.context.MessageSource;

import java.util.List;
import java.util.Optional;

public class PersonValidator {
    public static Person validateOptional(Optional<Person> optional, MessageSource messageSource, String locale)
            throws ApplicationBusinessException {

        return optional.orElseThrow(() -> new ApplicationBusinessException(DomainReturnCode.PERSON_NOT_FOUND.name(),
                DomainReturnCode.PERSON_NOT_FOUND.getTranslatedDescription(messageSource, locale)));
    }

    public static void validateToList(List<Person> personList, MessageSource messageSource, String locale) throws ApplicationBusinessException {
        if (personList.isEmpty()) {
            throw new ApplicationBusinessException(DomainReturnCode.PERSON_DATA_NOT_FOUND.name(),
                    DomainReturnCode.PERSON_DATA_NOT_FOUND.getTranslatedDescription(messageSource, locale));
        }
    }

    public static void validateToCreate(Person person, MessageSource messageSource, String locale) throws ApplicationBusinessException {
        if (person.getName().isEmpty()) {
            throw new ApplicationBusinessException(DomainReturnCode.PERSON_NAME_IS_EMPTY.name(),
                    DomainReturnCode.PERSON_NAME_IS_EMPTY.getTranslatedDescription(messageSource, locale));
        }
        if (person.getFishes().isEmpty()) {
            throw new ApplicationBusinessException(DomainReturnCode.PERSON_FISHES_IS_EMPTY.name(),
                    DomainReturnCode.PERSON_FISHES_IS_EMPTY.getTranslatedDescription(messageSource, locale));
        }
        if (person.getRegion().isEmpty()) {
            throw new ApplicationBusinessException(DomainReturnCode.PERSON_REGION_IS_EMPTY.name(),
                    DomainReturnCode.PERSON_REGION_IS_EMPTY.getTranslatedDescription(messageSource, locale));
        }
        if (person.getPhoneNumber().isEmpty()) {
            throw new ApplicationBusinessException(DomainReturnCode.PERSON_PHONE_IS_EMPTY.name(),
                    DomainReturnCode.PERSON_PHONE_IS_EMPTY.getTranslatedDescription(messageSource, locale));
        }
        if (person.getType() == null) {
            throw new ApplicationBusinessException(DomainReturnCode.PERSON_TYPE_IS_EMPTY.name(),
                    DomainReturnCode.PERSON_TYPE_IS_EMPTY.getTranslatedDescription(messageSource, locale));
        }
    }
}
