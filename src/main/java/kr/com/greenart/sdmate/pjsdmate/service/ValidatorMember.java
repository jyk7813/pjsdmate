package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.repository.MemberRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidatorMember {

    private Map<String, String> errors = new HashMap<>();

    private void checkNull(String value, String fieldName) {
            if (value == null || value.trim().isEmpty()) {
                errors.put(fieldName + "null", fieldName + "를(을) 입력해야합니다");
            }
        }

        private void checkMaxLength(String value,String fieldName,int max) {
            if(value !=null &&value.length()>max) {
                errors.put(fieldName+"TooLong",fieldName + "은"+max+"자 이하여야 합니다");
            }
        }
    private void checkMinLength(String value,String fieldName,int min) {
        if(value !=null &&value.length()<min) {
            errors.put(fieldName+"TooLong",fieldName + "은"+min+"자 이상이여야 합니다");
        }
    }
        
        private void checkSymbolId(String id,String fieldName){
            String regex = ".*[\\p{P}\\s].*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(id);
            if(matcher.matches()){
                errors.put(fieldName+"TooLong",fieldName + "는 특수기호,공백을 포함해선 안됩니다." );
            }
        }

        private void checkBlackPlacePassword(String password,String fieldName){

            String regex = ".*\\s.*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if(matcher.matches()){
                errors.put(fieldName+"TooLong",fieldName + "는 공백을 포함해선 안됩니다." );
            }
        }
        public Map<String, String> validateLogin(String memberid,String password) {
            checkNull(memberid, "아이디");
            checkNull(password, "비밀 번호");
            checkSymbolId(memberid,"아이디");
            checkBlackPlacePassword(password,"비밀번호");

            checkMaxLength(memberid, "아이디",15);
            checkMaxLength(password, "비밀 번호",15);

            checkMinLength(memberid,"아이디",4);
            checkMinLength(password,"비밀번호",8);

            return errors;
        }




        // 여기서 부턴 회원 가입 적합성 검사입니다
        public void validateDupulicate(Integer count,String fieldName){
            if(count == 1){
                errors.put(fieldName+"중복 에러",fieldName+" 가(이) 중복 됩니다.");
            }
        }
        public Map<String,String> validateJoin(Member member,Integer Id_Count,Integer Email_Count){
            checkNull(member.getName(), "이름");
            // 주민 번호  생년 월 일로 바뀌고 적합성 검사 데이터 받아보고 생각하기로 했기때문에 보류
            checkNull(member.getId(), "아이디");
            checkNull(member.getPwd(), "패스워드");
            checkNull(member.getEmail(), "이메일");
            checkNull(member.getPhonenum(), "전화번호");

            // 길이 체크
            checkMaxLength(member.getName(), "name", 10);
            // 주민 번호  생년 월 일로 바뀌고 적합성 검사 데이터 받아보고 생각하기로 했기때문에 보류
            checkMaxLength(member.getId(), "아이디",15);
            checkMaxLength(member.getPwd(), "비밀번호",15);

            checkMinLength(member.getId(),"아이디",4);
            checkMinLength(member.getPwd(),"비밀번호",8);

            // 형식이 존재하는 거는 형태 검사
            EmailRegex(member.getEmail(),"이메일");
            PhoneNumRegex(member.getPhonenum(),"전화번호");

            validateDupulicate(Id_Count,"아이디");
            validateDupulicate(Email_Count,"이메일");
            return errors;
        }
        public void EmailRegex(String email,String fieldName){
            String regex ="^.+@.+\\..+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if(!(matcher.matches())){
                errors.put(fieldName+"TooLong",fieldName + "형식에 맞지 않습니다." );
            }
        }
        public void PhoneNumRegex(String pn,String fieldName){
            String regex ="^\\d{2,3}-\\d{3,4}-\\d{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(pn);
            if(!(matcher.matches())){
                errors.put(fieldName+"TooLong",fieldName + "형식에 맞지 않습니다." );
            }
        }
        public void cleanMap(){
            errors.clear();
        }
    }

