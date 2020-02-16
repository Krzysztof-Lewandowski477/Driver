//package pl.driver.utils;
//
//import org.modelmapper.ModelMapper;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class ListMapper {
//
//    public static <T extends Object, G> List<T> mapList(List<G> sourceList){
//        ModelMapper mapper = new ModelMapper();
//        return sourceList.stream()
//                .map(s-> mapper.map(s, T.class))
//                .collect(Collectors.toList());
//    }
//
//}
