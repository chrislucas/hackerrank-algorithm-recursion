/**
 * https://www.hackerrank.com/challenges/recursive-digit-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking
 * DONE
 * https://math.stackexchange.com/questions/99725/every-integer-is-congruent-to-the-sum-of-its-digits-mod-9
 * http://www.sjsu.edu/faculty/watkins/Digitsum00.htm
 * */

public class Solution {

    private static int sumMod(int a, int b, int m) {
        return ((a%m)+(b%m))%m;
    }

    // NAIVE solution
    private static String solver(String n) {
        if (n.length() == 1) {
            return Integer.parseInt(n) == 0 ? String.valueOf(9) : n;
        }
        else {
            int acc = 0;
            for (int i = 0; i < n.length() ; i++) {
                acc = sumMod(acc, Integer.parseInt(String.valueOf(n.charAt(i))), 9);
            }
            String ans = solver(String.valueOf(acc));
            return ans;
        }
    }

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        k %= 9;
        if (k == 0)
            return 9;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <k ; i++) {
            sb = sb.append(n);
        }
        int q = Integer.parseInt(solver(sb.toString()));
        return q;
    }

    public static void main(String[] args) {
        System.out.println(superDigit("23659788316494901364755750388777795" +
                "75813226775851820912370812124502641538947920808397703549713678" +
                "4946839284977124371761402825893502776534792255206028134564332774" +
                "173666804261986336818911843487570072929074091603537452211253542120" +
                "9552878412472844777095986143939035030831391736502136354171261868694294677" +
                "332400314600842420568863037165675756101222474490180072691124642327218630" +
                "159549099325379138610227020196599666270721530074851673222393585881646" +
                "6886068592299708740453558018878677753623653080545592459765998008028026" +
                "9825106894692137382412058024460291548334580488940026469341190826214983" +
                "4144522149119095545954837108383962559050522868101772467831557253155198875856" +
                "8150699821635779156685637531274097856486075649357610713833072735231599919848220063" +
                "0264297181377662867163433850596991332116991899333391748436252663985030992034161244660" +
                "327114538544139337375368364061059918577447663444611622226708767327291715855124686155" +
                "584999797202694279227984313122704837320043925039051602334578115254284327877325437997833" +
                "09593536386190295516419339222642886780012683583264436427241020490358960438948951090123073035203797984302163150042110707217274102457735317367100133807782064391421012191958312396649052833396257876824943425814834615313474161638240747120342368147351931074481983318414461554116111216672594256301273113776892080967125790153125125885441941114178586071406149630777323200516190208241341822285244325578953416388462284725673478766919050744786263188733438572307443267700831425575113213359873223948072988922668251652320316884761627830570057061821492039968369341602081382603302965910382997241199808824091331180464950187035576778206683245316006405529597170652549163351875206280564448346510252775085876212617353369513619186390565654064068546863018765466029315754619416429621887091818939474391383675337791979997519954871635692656223852981330368145996344325688247632566665645262588764650823901065646663460851602833982853795901687202035893967893724362979886948663" +
                "3694286895855097154420196623250242945817052658080225703653516454958026868919553480" +
                "8455061553875080928749824126040867351774660858283312369602738035303834821878633171033" +
                "4697053069152326732702246704177127367642287975998486114018970510842276024855162228267" +
                "76775594803002972357364690884410904937424445658047492205825096426043772127838006931197" +
                "24550771022661670984657888452610163957723929042804111677634435712851413885670748059863" +
                "31207454652671618663858701085276806486000014124900483188940484497173286284987124699515" +
                "03983118390238387712013678849233990331609369393883373054824717479955309240267108331328581300390336362521937003941361085030896655894805793258357677149203781146043935954290262459966158862429523225261624518684497599518021888923040396808788810849421481923499200718224156284437696171143849110558539064533216154454232609586964244573382366180622869720827765642632612893854612576116696035148294853911413328081091631787336041983606762511611400137767292933363876" +
                "829209523680915334942689489686944619739567177193292821110938588494027416" +
                "03881520278851300019080955159875192070999736684156998188051008906908961263" +
                "450992498366163487027427765593685910042542987342924303131325068629313398525994509" +
                "6112059116986548403694329404525780119310272840088752638347797052372063090086779511121" +
                "0451854194391002244150921934506879640791680297603712618076174694948300699937409787596860" +
                "516266369711284028834238022724596540529491965656156574337073988564171171562036245389632" +
                "730259264953520190321920347601255396137920500496074443380910841069973360586715775083998" +
                "842187392360751892748665579312212647821816086677544702037289983388842777905728540745718" +
                "314922321086695691823249801139552886748181144717500999021690749662561227798159566905725" +
                "946118195067702032931332172088385727012140744362147720922176656204772910422189621" +
                "466379287662792372374145383317294646977085291873933547226857758530880168793511465" +
                "268400187943977613894365634645591604177130794105552582447385631392788652188052953" +
                "41478112965567143978815151399630423102435884302310535415733856427000390467373617810" +
                "950255065071316725831952254582405652479178110518163923712787535641726887824964217168" +
                "87440701599858672119414943965662163653929916279628869021987126139820176032371746828258" +
                "147979839670540382698330087284073459126996230046234672877382961107742120052940507992182" +
                "2765498382023579606923609970691152580624493368354861965192530043584698986813897694400682" +
                "2652462513903624200398184640627878400159480147462063679751851193719499676402496701528971830054482832320057097082360875809145428036636600549270698504540758319126452884313155162288201445118708935758033035083555929081756050975974040793712887964439001525986626643925845343840647344753344394209812309532147589135665638895095150172324875219965305745649692175878476631167339609984047545458299489650202318886162798841051758853022389219423402386031324398337411422060786064174337895040820526914615325075313448800789763344707190242881920892579588963376086146960633381215378914452523108903834607764477580583821712879080194987840450703336371649758616364805184545636558639909806705757141231728890945705281578891764357530862478284617890886615612608017861029342475376559517893073874528735689724989147963227442563141916115837740823088920018306622898786665697436694114134566032298418513134640110497915781256013658157" +
                "626876007303865007938799121914067544773285391447059337068967640221461662745594510968605338966108977317081902507941847885331172633986644666002196037962414608353479436996966565895587993028389782659415971152403029518493019029205611785920255633270560095438637318885230551138363908343081523545591224134467205438637992783829259919217744713264231649621461535887435410548366408012977973203459983761967831442350892580662433295719596302715165438994052920660204857279403439598616231631708579334309451829396365207336409446940374623441420435439989058506571776629533788131454314121504595268258657172190365178279637763408587826711292793610001999656837923788319438384372260168303662843086203813103771712423574817520332644704407707584630263836497460974781867543909787940278207946350316762434685271126547340568379697114143432270663747926423410939366867323227307888313764100323948708488249291932762190879422500980573314510481474989813161818046596342997489244092851481456635241462079248335760582513488928151459281907438730238065382341691833250917737617330046824951709287812847967496061820848573006896422220098029186444659696393722864425443174804115295661452095886127784785656396807536597522937517010395385281668735072368362229248386090765688300603292905737705424037244946746445640174635429078019229973366378415273692915764515173009646632256826278792193749314522687455317800604524740119271772480341422364037622841158408693597798800732407214231715176216414119458470398433698630492023148912788371335047944731850924533486580463894436416946298869397354691924065211837844914014837056117850937923852135361875895012428779496342389871713463333419295329258828037504468306416370691252321110783303933730724981220411655523128107813025668960480700236419568269112404054054013255954297124592253625509027169128346186086879842249233969016492009074059375814396213470661585889025858173286307393463166771278528359358679107663618852904436981159408575155381452852538538161326799566605463071606829507721627760695695298663348037499346965080571845983286426728562771057921340809114888275207834276278723670038713251819678117637307797126524335451875674322135660001938501046206646725087020563845482789165114015140237476770960542212541262365674096922377749965211055083880951870947588439313087505990968967904452943561444336754539161497904651842954423690339860136920316455021978105823558793189756025331264642326253916951167641064028719315782248353333706214902160610987866723541787809188383034860801960339654982067421224921066723519523759569071993168783868197116308035921525346492767986090665094574147296651701824963729081365854249511700896706324052098265362182297874817162325372836249682033460453106454759294279011517085352648052686287835826956331856000530656816094258663224239727567999798475939204052755892731997428948369450364798425229576414764799300949556003266863462364785971588403993047829919672884685002127952124093077144535644623315342420032186819555104280110883937594970132297831017511120535205810256141119655336117669459771376005411248881994640753601606805393583940281645304757423903447751752383876356426048210439751541893763188890403792485964646286690953432929961087972625329578244854544295899075470411907779181886987220577672224785177419791954783277253421243333498197370278143247403594312138218592254174197047846302000164735966226394070001204323764164912690541799927573761616438820835021411743898829210130296149250887986491553547221899402096605456148489590866922112294624680546281250567297009605663936998939340731539740128008013832941045470722922727419033890751091173021386847464099733717633316304536930447077599861319788266450790785072377536483225439587367122393671167950836029510856465462738804587713268436992128892171509071641161165880608224322539890931445909082786991260734902410993863449929626354001121991398640542747424891140797115509495342486678389565402504229791244504867508301342798992744796454984189142033193018659744179186808244403688375727771580862592404226696538971232713170205127941869698531179001250635892043048835137445218382957976989721755706861701366347894376710532041643279157597459032202591566808167568419301491754821992741943996185368155017334681412500723160011387595363158410560488203993638466615700276165502049790282263414502568166837301414930688269694553727263733690839349714652132206285243796184219815308355634318194592022805870387606542297381666905458451054204419608774066516116961329031388338821535694456637910702328420582124442440139995352494707284230907975581024232726130673375360163257154562557607055131368534412734263401317160921075802949888891100336188281116884460133424076740001934250575466042922149519629860344218277351996828116545149383178424384811799946144322536711027462093434842033767504492071349955677051700618860129870409856113128392373584622061075886499407885141951318807519645386474", 10000));

        System.out.println(superDigit("9875", 5));
        System.out.println(superDigit("9875", 50));
        System.out.println(superDigit("9875", 500));
        System.out.println(superDigit("9875", 10000));

        System.out.println(superDigit("123", 3));
        System.out.println(superDigit("148", 3));
        System.out.println(superDigit("148112", 300));
    }
}
