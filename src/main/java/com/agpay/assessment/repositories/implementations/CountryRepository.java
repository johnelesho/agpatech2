package com.agpay.assessment.repositories.implementations;

import com.agpay.assessment.dtos.CountryDto;
import com.agpay.assessment.entities.Country;
import com.agpay.assessment.etc.ApiHelper;
import com.agpay.assessment.etc.CountryInfoEnum;
import com.agpay.assessment.exceptions.*;
import com.agpay.assessment.exceptions.UnableToCreateCountryException;
import com.agpay.assessment.mapper.CountryMapper;
import com.agpay.assessment.repositories.contracts.ICountryRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CountryRepository implements ICountryRepository {

    private static List<Country> countries = new ArrayList<Country>(
            Arrays.asList(
                    new Country(1,"Afghanistan","38928346","652860","60"),
                    new Country(2,"Albania","2877797","27400","105"),
                    new Country(3,"Algeria","43851044","2381740","18"),
                    new Country(4,"Andorra","77265","470","164"),
                    new Country(5,"Angola","32866272","1246700","26"),
                    new Country(6,"Antigua and Barbuda","97929","440","223"),
                    new Country(7,"Argentina","45195774","2736690","17"),
                    new Country(8,"Armenia","2963243","28470","104"),
                    new Country(9,"Australia","25499884","7682300","3"),
                    new Country(10,"Austria","9006398","82409","109"),
                    new Country(11,"Azerbaijan","10139177","82658","123"),
                    new Country(12,"Bahamas","393244","10010","39"),
                    new Country(13,"Bahrain","1701575","760","2239"),
                    new Country(14,"Bangladesh","164689383","130170","1265"),
                    new Country(15,"Barbados","287375","430","668"),
                    new Country(16,"Belarus","9449323","202910","47"),
                    new Country(17,"Belgium","11589623","30280","383"),
                    new Country(18,"Belize","397628","22810","17"),
                    new Country(19,"Benin","12123200","112760","108"),
                    new Country(20,"Bhutan","771608","38117","20"),
                    new Country(21,"Bolivia","11673021","1083300","11"),
                    new Country(22,"Bosnia and Herzegovina","3280819","51000","64"),
                    new Country(23,"Botswana","2351627","566730","4"),
                    new Country(24,"Brazil","212559417","8358140","25"),
                    new Country(25,"Brunei","437479","5270","83"),
                    new Country(26,"Bulgaria","6948445","108560","64"),
                    new Country(27,"Burkina Faso","20903273","273600","76"),
                    new Country(28,"Burundi","11890784","25680","463"),
                    new Country(29,"Côte d'Ivoire","26378274","318000","83"),
                    new Country(30,"Cabo Verde","555987","4030","138"),
                    new Country(31,"Cambodia","16718965","176520","95"),
                    new Country(32,"Cameroon","26545863","472710","56"),
                    new Country(33,"Canada","37742154","9093510","4"),
                    new Country(34,"Central African Republic","4829767","622980","8"),
                    new Country(35,"Chad","16425864","1259200","13"),
                    new Country(36,"Chile","19116201","743532","26"),
                    new Country(37,"China","1439323776","9388211","153"),
                    new Country(38,"Colombia","50882891","1109500","46"),
                    new Country(39,"Comoros","869601","1861","467"),
                    new Country(40,"Congo (Congo-Brazzaville)","5518087","341500","16"),
                    new Country(41,"Costa Rica","5094118","51060","100"),
                    new Country(42,"Croatia","4105267","55960","73"),
                    new Country(43,"Cuba","11326616","106440","106"),
                    new Country(44,"Cyprus","1207359","9240","131"),
                    new Country(45,"Czechia (Czech Republic)","10708981","77240","139"),
                    new Country(46,"Democratic Republic of the Congo","89561403","2267050","40"),
                    new Country(47,"Denmark","5792202","42430","137"),
                    new Country(48,"Djibouti","988000","23180","43"),
                    new Country(49,"Dominica","71986","750","96"),
                    new Country(50,"Dominican Republic","10847910","48320","225"),
                    new Country(51,"Ecuador","17643054","248360","71"),
                    new Country(52,"Egypt","102334404","995450","103"),
                    new Country(53,"El Salvador","6486205","20720","313"),
                    new Country(54,"Equatorial Guinea","1402985","28050","50"),
                    new Country(55,"Eritrea","3546421","101000","35"),
                    new Country(56,"Estonia","1326535","42390","31"),
                    new Country(57,"Eswatini (fmr. Swaziland)","1160164","17200","67"),
                    new Country(58,"Ethiopia","114963588","1000000","115"),
                    new Country(59,"Fiji","896445","18270","49"),
                    new Country(60,"Finland","5540720","303890","18"),
                    new Country(61,"France","65273511","547557","119"),
                    new Country(62,"Gabon","2225734","257670","9"),
                    new Country(63,"Gambia","2416668","10120","239"),
                    new Country(64,"Georgia","3989167","69490","57"),
                    new Country(65,"Germany","83783942","348560","240"),
                    new Country(66,"Ghana","31072940","227540","137"),
                    new Country(67,"Greece","10423054","128900","81"),
                    new Country(68,"Grenada","112523","340","331"),
                    new Country(69,"Guatemala","17915568","107160","167"),
                    new Country(70,"Guinea","13132795","245720","53"),
                    new Country(71,"Guinea-Bissau","1968001","28120","70"),
                    new Country(72,"Guyana","786552","196850","4"),
                    new Country(73,"Haiti","11402528","27560","414"),
                    new Country(74,"Holy See","801","0","2003"),
                    new Country(75,"Honduras","9904607","111890","89"),
                    new Country(76,"Hungary","9660351","90530","107"),
                    new Country(77,"Iceland","341243","100250","3"),
                    new Country(78,"India","1380004385","2973190","464"),
                    new Country(79,"Indonesia","273523615","1811570","151"),
                    new Country(80,"Iran","83992949","1628550","52"),
                    new Country(81,"Iraq","40222493","434320","93"),
                    new Country(82,"Ireland","4937786","68890","72"),
                    new Country(83,"Israel","8655535","21640","400"),
                    new Country(84,"Italy","60461826","294140","206"),
                    new Country(85,"Jamaica","2961167","10830","273"),
                    new Country(86,"Japan","126476461","364555","347"),
                    new Country(87,"Jordan","10203134","88780","115"),
                    new Country(88,"Kazakhstan","18776707","2699700","7"),
                    new Country(89,"Kenya","53771296","569140","94"),
                    new Country(90,"Kiribati","119449","810","147"),
                    new Country(91,"Kuwait","4270571","17820","240"),
                    new Country(92,"Kyrgyzstan","6524195","191800","34"),
                    new Country(93,"Laos","7275560","230800","32"),
                    new Country(94,"Latvia","1886198","62200","30"),
                    new Country(95,"Lebanon","6825445","10230","667"),
                    new Country(96,"Lesotho","2142249","30360","71"),
                    new Country(97,"Liberia","5057681","96320","53"),
                    new Country(98,"Libya","6871292","1759540","4"),
                    new Country(99,"Liechtenstein","38128","160","238"),
                    new Country(100,"Lithuania","2722289","62674","43"),
                    new Country(101,"Luxembourg","625978","2590","242"),
                    new Country(102,"Madagascar","27691018","581795","48"),
                    new Country(103,"Malawi","19129952","94280","203"),
                    new Country(104,"Malaysia","32365999","328550","99"),
                    new Country(105,"Maldives","540544","300","1802"),
                    new Country(106,"Mali","20250833","1220190","17"),
                    new Country(107,"Malta","441543","320","1380"),
                    new Country(108,"Marshall Islands","59190","180","329"),
                    new Country(109,"Mauritania","4649658","1030700","5"),
                    new Country(110,"Mauritius","1271768","2030","626"),
                    new Country(111,"Mexico","128932753","1943950","66"),
                    new Country(112,"Micronesia","548914","700","784"),
                    new Country(113,"Moldova","4033963","32850","123"),
                    new Country(114,"Monaco","39242","1","26337"),
                    new Country(115,"Mongolia","3278290","1553560","2"),
                    new Country(116,"Montenegro","628066","13450","47"),
                    new Country(117,"Morocco","36910560","446300","83"),
                    new Country(118,"Mozambique","31255435","786380","40"),
                    new Country(119,"Myanmar (formerly Burma)","54409800","653290","83"),
                    new Country(120,"Namibia","2540905","823290","3"),
                    new Country(121,"Nauru","10824","20","541"),
                    new Country(122,"Nepal","29136808","143350","203"),
                    new Country(123,"Netherlands","17134872","33720","508"),
                    new Country(124,"New Zealand","4822233","263310","18"),
                    new Country(125,"Nicaragua","6624554","120340","55"),
                    new Country(126,"Niger","24206644","1266700","19"),
                    new Country(127,"Nigeria","206139589","910770","226"),
                    new Country(128,"North Korea","25778816","120410","214"),
                    new Country(129,"North Macedonia","2083374","25220","83"),
                    new Country(130,"Norway","5421241","365268","15"),
                    new Country(131,"Oman","5106626","309500","16"),
                    new Country(132,"Pakistan","220892340","770880","287"),
                    new Country(133,"Palau","18094","460","39"),
                    new Country(134,"Palestine State","5101414","6020","847"),
                    new Country(135,"Panama","4314767","74340","58"),
                    new Country(136,"Papua New Guinea","8947024","452860","20"),
                    new Country(137,"Paraguay","7132538","397300","18"),
                    new Country(138,"Peru","32971854","1280000","26"),
                    new Country(139,"Philippines","109581078","298170","368"),
                    new Country(140,"Poland","37846611","306230","124"),
                    new Country(141,"Portugal","10196709","91590","111"),
                    new Country(142,"Qatar","2881053","11610","248"),
                    new Country(143,"Romania","19237691","230170","84"),
                    new Country(144,"Russia","145934462","16376870","9"),
                    new Country(145,"Rwanda","12952218","24670","525"),
                    new Country(146,"Saint Kitt and Nevis","53199","260","205"),
                    new Country(147,"Saint Lucia","183627","610","301"),
                    new Country(148,"Saint Vincen and the Grenadines","110940","390","284"),
                    new Country(149,"Samoa","198414","2830","70"),
                    new Country(150,"San Marino","33931","60","566"),
                    new Country(151,"Sao Tom and Principe","219159","960","228"),
                    new Country(152,"Saudi Arabia","34813871","2149690","16"),
                    new Country(153,"Senegal","16743927","192530","87"),
                    new Country(154,"Serbia","8737371","87460","100"),
                    new Country(155,"Seychelles","98347","460","214"),
                    new Country(156,"Sierra Leone","7976983","72180","111"),
                    new Country(157,"Singapore","5850342","700","8358"),
                    new Country(158,"Slovakia","5459642","48088","114"),
                    new Country(159,"Slovenia","2078938","20140","103"),
                    new Country(160,"Solomon Islands","686884","27990","25"),
                    new Country(161,"Somalia","15893222","627340","25"),
                    new Country(162,"South Africa","59308690","1213090","49"),
                    new Country(163,"South Korea","51269185","97230","527"),
                    new Country(164,"South Sudan","11193725","610952","18"),
                    new Country(165,"Spain","46754778","498800","94"),
                    new Country(166,"Sri Lanka","21413249","62710","341"),
                    new Country(167,"Sudan","43849260","1765048","25"),
                    new Country(168,"Suriname","586632","156000","4"),
                    new Country(169,"Sweden","10099265","410340","25"),
                    new Country(170,"Switzerland","8654622","39516","219"),
                    new Country(171,"Syria","17500658","183630","95"),
                    new Country(172,"Tajikistan","9537645","139960","68"),
                    new Country(173,"Tanzania","59734218","885800","67"),
                    new Country(174,"Thailand","69799978","510890","137"),
                    new Country(175,"Timor-Leste","1318445","14870","89"),
                    new Country(176,"Togo","8278724","54390","152"),
                    new Country(177,"Tonga","105695","720","147"),
                    new Country(178,"Trinidad and Tobago","1399488","5130","273"),
                    new Country(179,"Tunisia","11818619","155360","76"),
                    new Country(180,"Turkey","84339067","769630","110"),
                    new Country(181,"Turkmenistan","6031200","469930","13"),
                    new Country(182,"Tuvalu","11792","30","393"),
                    new Country(183,"Uganda","45741007","199810","229"),
                    new Country(184,"Ukraine","43733762","579320","75"),
                    new Country(185,"United Arab Emirates","9890402","83600","118"),
                    new Country(186,"United Kingdom","67886011","241930","281"),
                    new Country(187,"United States of America","331002651","9147420","36"),
                    new Country(188,"Uruguay","3473730","175020","20"),
                    new Country(189,"Uzbekistan","33469203","425400","79"),
                    new Country(190,"Vanuatu","307145","12190","25")
//                    new Country(191,"Venezuela","28435940","882050","32"),
//                    new Country(192,"Vietnam","97338579","310070","314"),
//                    new Country(193,"Yemen","29825964","527970","56"),
//                    new Country(194,"Zambia","18383955","743390","25"),
//                    new Country(195,"Zimbabwe","14862924","386850","38")
            )
    );

    @Override
    public List<Country> findAll() {
        return countries;
    }

    @Override
    public List<Country> findAllByName(String search, int page, int size) {
        List<Country> response = null;

        try{
            if(ApiHelper.isEmpty(search)){
                response = countries;

                int fromIndex= (page * size);
                int toIndex = ((size*page)+size) > countries.size()? countries.size() : ((size*page)+size);

                if(fromIndex > countries.size()){
                    throw new BadRequestException("Insufficient Records");
                }
                return response.subList(fromIndex, toIndex);
            }
            else{
               return countries.stream().filter(country -> country.getName().trim().toLowerCase().contains(search.trim().toLowerCase()))
                        .collect(Collectors.toList());
            }

        }catch (IndexOutOfBoundsException ex){
            throw new BadRequestException("Insufficient Records");
        }


    }


    @Override
    public List<Country> findAllBy(String key) {
        return null;
    }

    @Override
    public Country save(CountryDto dto) {
        Country country = countries.stream().filter(c -> c.getName().equalsIgnoreCase(dto.name()))
                .findFirst().orElse(null);
        if (ApiHelper.isNotEmpty(country)) {
                throw new RecordExistsException();
        }
        int id = countries.size() + 1;
        country = CountryMapper.DtoToCountry(dto, id);
        boolean isCountryAdded = countries.add(country);
        if(isCountryAdded){
            System.out.println(countries);
            return country;
        }
        throw new UnableToCreateCountryException();
    }

    @Override
    public List<Country> saveAll(List<CountryDto> requests) {
        int id = countries.size();
        List<Country> tobeAdded = new ArrayList<>();
    for(CountryDto dto : requests){
        Country country = countries.stream().filter(c -> c.getName().equalsIgnoreCase(dto.name())).findFirst().orElse(null);
        if(ApiHelper.isEmpty(country)){
           country= CountryMapper.DtoToCountry(dto, id++);
            tobeAdded.add(country);
        }
    }
        boolean isCountryAdded = countries.addAll(tobeAdded);
        if(isCountryAdded){
            return tobeAdded;
        };

        throw new UnableToCreateCountryException();
    }

    @Override
    public List<Country> findAllByName(String search) {
        if(ApiHelper.isEmpty(search)){
            return countries;
        }
        return  countries.stream().filter(country -> country.getName().trim().toLowerCase().contains(search.trim().toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Country findById(int id) {
        try{
            System.out.println(id);
            Country country = countries.get(--id);
            if (ApiHelper.isEmpty(country)){
                throw new RecordNotFoundException();
            }
            return country;
        }catch (Exception ex){
            throw new RecordNotFoundException();
        }


    }


    @Override
    public Country findByName(String value) {
        return countries.stream().filter(country -> {
                    System.out.println(country.getName());
                    System.out.println(value);
                    return country.getName().trim().toLowerCase().contains(value.trim().toLowerCase());})
                .findFirst().orElseThrow(()->new RecordNotFoundException());
    }

    @Override
    public Country findBy(CountryInfoEnum key, Object value) {
        String k = key.name();
        if (ApiHelper.isEmpty(value) || ApiHelper.isEmpty(key)){
            throw new BadRequestException();
        }
        if (Arrays.asList(Country.class.getDeclaredFields()).contains(key)){
            return countries.stream().filter(country -> country.get(k).equals(value))
                    .findFirst().orElseThrow(()->new RecordNotFoundException());
        }

        else{
            throw new RecordNotFoundException();
        }



    }



    @Override
    public Country updateById(int id, CountryDto dto) throws IllegalAccessException {
       if (ApiHelper.isEmpty(dto)){
           throw new BadRequestException();
       }
        Country country = findById(id);
       if(countries.remove(country)) {
           for (Field field : dto.getClass().getDeclaredFields()) {
               if (field.get(dto) != null) {
                   field.set(country, field.get(dto));
               }
           }
           boolean isCountryAdded = countries.add(country);
           if(isCountryAdded){
               return country;
           }
       }

 throw new UnableToUpdateCountryException();
       }



    @Override
    public Country updateByName(String name, CountryDto dto) throws IllegalAccessException {
        if (ApiHelper.isEmpty(dto)){
            throw new BadRequestException();
        }
        Country country = findBy(CountryInfoEnum.name, name);
        if(countries.remove(country)) {
            for (Field field : dto.getClass().getDeclaredFields()) {
                if (field.get(dto) != null) {
                    field.set(country, field.get(dto));
                }
            }
            boolean isCountryAdded = countries.add(country);
            if(isCountryAdded){
                return country;
            }
        }
        throw new UnableToUpdateCountryException();
    }



}
