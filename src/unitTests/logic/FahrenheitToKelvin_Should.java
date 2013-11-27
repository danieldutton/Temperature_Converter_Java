package unitTests.logic;


import logic.algorithms.FahrenheitToCelsius;
import logic.algorithms.FahrenheitToKelvin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FahrenheitToKelvin_Should {

    private static FahrenheitToKelvin fahrenheitToKelvin = new FahrenheitToKelvin();

    private double input;
    private double expected;
    private static final double DELTA = 1e-8;


    public FahrenheitToKelvin_Should(double input, double expected){
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static List<Object[]>data(){
        return Arrays.asList(new Object[][]{

             // -150F to -100 F
            {-150.0,172},
            {-149.0,173}, {-139.0,178}, {-129.0,184}, {-119.0,189}, {-109.0,195},
            {-148.0,173}, {-138.0,179}, {-128.0,184}, {-118.0,190}, {-108.0,195},
            {-147.0,174}, {-137.0,179}, {-127.0,185}, {-117.0,190}, {-107.0,196},
            {-146.0,174}, {-136.0,180}, {-126.0,185}, {-116.0,191}, {-106.0,196},
            {-145.0,175}, {-135.0,180}, {-125.0,186}, {-115.0,191}, {-105.0,197},
            {-144.0,175}, {-134.0,181}, {-124.0,186}, {-114.0,192}, {-104.0,198},
            {-143.0,176}, {-133.0,181}, {-123.0,187}, {-113.0,193}, {-103.0,198},
            {-142.0,176}, {-132.0,182}, {-122.0,188}, {-112.0,193}, {-102.0,199},
            {-141.0,177}, {-131.0,183}, {-121.0,188}, {-111.0,194}, {-101.0,199},
            {-140.0,178}, {-130.0,183}, {-120.0,189}, {-110.0,194}, {-100.0,200},

            // -99F to -50 F
            {-99.0,200}, {-89.0,206}, {-79.0,211}, {-69.0,217}, {-59.0,223},
            {-98.0,201}, {-88.0,206}, {-78.0,212}, {-68.0,218}, {-58.0,223},
            {-97.0,201}, {-87.0,207}, {-77.0,213}, {-67.0,218}, {-57.0,224},
            {-96.0,202}, {-86.0,208}, {-76.0,213}, {-66.0,219}, {-56.0,224},
            {-95.0,203}, {-85.0,208}, {-75.0,214}, {-65.0,219}, {-55.0,225},
            {-94.0,203}, {-84.0,209}, {-74.0,214}, {-64.0,220}, {-54.0,225},
            {-93.0,204}, {-83.0,209}, {-73.0,215}, {-63.0,220}, {-53.0,226},
            {-92.0,204}, {-82.0,210}, {-72.0,215}, {-62.0,221}, {-52.0,226},
            {-91.0,205}, {-81.0,210}, {-71.0,216}, {-61.0,221}, {-51.0,227},
            {-90.0,205}, {-80.0,211}, {-70.0,216}, {-60.0,222}, {-50.0,228},

            // -49F to 0 F
            {-49.0,228}, {-39.0,234}, {-29.0,239}, {-19.0,245}, {-9.0,250},
            {-48.0,229}, {-38.0,234}, {-28.0,240}, {-18.0,245}, {-8.0,251},
            {-47.0,229}, {-37.0,235}, {-27.0,240}, {-17.0,246}, {-7.0,251},
            {-46.0,230}, {-36.0,235}, {-26.0,241}, {-16.0,246}, {-6.0,252},
            {-45.0,230}, {-35.0,236}, {-25.0,241}, {-15.0,247}, {-5.0,253},
            {-44.0,231}, {-34.0,236}, {-24.0,242}, {-14.0,248}, {-4.0,253},
            {-43.0,231}, {-33.0,237}, {-23.0,243}, {-13.0,248}, {-3.0,254},
            {-42.0,232}, {-32.0,238}, {-22.0,243}, {-12.0,249}, {-2.0,254},
            {-41.0,233}, {-31.0,238}, {-21.0,244}, {-11.0,249}, {-1.0,255},
            {-40.0,233}, {-30.0,239}, {-20.0,244}, {-10.0,250}, {0.0,255},

            // 0F to 50F
            {0.0,255},
            {1.0,256}, {11.0,261}, {21.0,267}, {31.0,273}, {41.0,278},
            {2.0,256}, {12.0,262}, {22.0,268}, {32.0,273}, {42.0,279},
            {3.0,257}, {13.0,263}, {23.0,268}, {33.0,274}, {43.0,279},
            {4.0,258}, {14.0,263}, {24.0,269}, {34.0,274}, {44.0,280},
            {5.0,258}, {15.0,264}, {25.0,269}, {35.0,275}, {45.0,280},
            {6.0,259}, {16.0,264}, {26.0,270}, {36.0,275}, {46.0,281},
            {7.0,259}, {17.0,265}, {27.0,270}, {37.0,276}, {47.0,281},
            {8.0,260}, {18.0,265}, {28.0,271}, {38.0,276}, {48.0,282},
            {9.0,260}, {19.0,266}, {29.0,271}, {39.0,277}, {49.0,283},
            {10.0,261},{20.0,266}, {30.0,272}, {40.0,278}, {50.0,283},

            //50F to 100F
            {51.0,284}, {61.0,289}, {71.0,295}, {81.0,300}, {91.0,306},
            {52.0,284}, {62.0,290}, {72.0,295}, {82.0,301}, {92.0,306},
            {53.0,285}, {63.0,290}, {73.0,296}, {83.0,301}, {93.0,307},
            {54.0,285}, {64.0,291}, {74.0,296}, {84.0,302}, {94.0,308},
            {55.0,286}, {65.0,291}, {75.0,297}, {85.0,303}, {95.0,308},
            {56.0,286}, {66.0,292}, {76.0,298}, {86.0,303}, {96.0,309},
            {57.0,287}, {67.0,293}, {77.0,298}, {87.0,304}, {97.0,309},
            {58.0,288}, {68.0,293}, {78.0,299}, {88.0,304}, {98.0,310},
            {59.0,288}, {69.0,294}, {79.0,299}, {89.0,305}, {99.0,310},
            {60.0,289}, {70.0,294}, {80.0,300}, {90.0,305}, {100.0,311},

            //100F to 150F
            {101.0,311}, {111.0,317}, {121.0,323}, {131.0,328}, {141.0,334},
            {102.0,312}, {112.0,318}, {122.0,323}, {132.0,329}, {142.0,334},
            {103.0,313}, {113.0,318}, {123.0,324}, {133.0,329}, {143.0,335},
            {104.0,313}, {114.0,319}, {124.0,324}, {134.0,330}, {144.0,335},
            {105.0,314}, {115.0,319}, {125.0,325}, {135.0,330}, {145.0,336},
            {106.0,314}, {116.0,320}, {126.0,325}, {136.0,331}, {146.0,336},
            {107.0,315}, {117.0,320}, {127.0,326}, {137.0,331}, {147.0,337},
            {108.0,315}, {118.0,321}, {128.0,326}, {138.0,332}, {148.0,338},
            {109.0,316}, {119.0,321}, {129.0,327}, {139.0,333}, {149.0,338},
            {110.0,316}, {120.0,322}, {130.0,328}, {140.0,333}, {150.0,339},
        });
    }

    @Test
    public void testQuotes(){
        assertEquals(expected, fahrenheitToKelvin.Convert(input, true), DELTA);
    }
}
