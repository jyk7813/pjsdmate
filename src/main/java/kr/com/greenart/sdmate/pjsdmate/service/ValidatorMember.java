package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidatorMember {
    private Map<String, String> errors = new HashMap<>();
        private void checkNull(String value, String fieldName, Map<String, String> errors) {
            if (value == null || value.trim().isEmpty()) {
                errors.put(fieldName + "null", fieldName + "를(을) 입력해야합니다");
            }
        }

        private void checkMaxLength(String value,String fieldName,int max, Map<String,String> errors) {
            if(value !=null &&value.length()>max) {
                errors.put(fieldName+"TooLong",fieldName + "은"+max+"자 이하여야 합니다");
            }
        }

        private void checkSymbolId(String id,String fieldName,Map<String,String> errors){
            String regex = ".*[\\p{P}\\s].*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(id);
            if(matcher.matches()){
                errors.put(fieldName+"TooLong",fieldName + "는 특수기호,공백을 포함해선 안됩니다." );
            }
        }

        private void checkBlackPlacePassword(String password,String fieldName,Map<String,String> errors){

            String regex = ".*\\s.*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if(matcher.matches()){
                errors.put(fieldName+"TooLong",fieldName + "는 공백을 포함해선 안됩니다." );
            }
        }
        public Map<String, String> validate(String memberid,String password) {
            checkNull(memberid, "아이디", errors);
            checkNull(password, "비밀 번호", errors);
            checkSymbolId(memberid,"아이디",errors);
            checkBlackPlacePassword(password,"비밀번호",errors);

            checkMaxLength(memberid, "아이디",15,errors);
            checkMaxLength(password, "비밀 번호",15,errors);

            return errors;
        }
//        public Map<String,String> joinValidate(Member member){
//
//            return
//        }

        public Map<String, String> validateName(String name){

            checkNull(name,"name",errors);
            checkMaxLength(name, "name", 20, errors);

            return errors;
        }

        public void cleanMap(){
            errors.clear();
        }
    }

