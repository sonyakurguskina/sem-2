<!doctype html>
<html lang="en" xmlns:margin-left="http://www.w3.org/1999/xhtml" xmlns:margin-right="http://www.w3.org/1999/xhtml"
      xmlns:width="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <title>Blog</title>
    <link href="css/blog.css" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <style type = "text/css">
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }

            .container {
                padding-right: 15px;
                padding-left: 15px;
                padding-bottom: 15px;
                margin-right: auto;
                margin-left: auto;
            }

            a{
                text-decoration: none;
            }

            @media (min-width: 1200px) {
                .container {
                    width: 1170px
                }
            }
        }
    </style>
</head>
<div>
    <div class="container">
        <header class="blog-header py-1">
            <div class="row flex-nowrap justify-content-between align-items-center">
                <div class="d-flex justify-content-center">
                    <a class="blog-header-logo text-dark" href="/mainpage">United Internet</a>
                </div>
            </div>
            <form class="form-signin" action="searchedUsers" method = "post">
            <div class="d-flex justify-content-end" class="col-md-6 mb-3" weight = 45>
             <form class="form-signin" action="searchedUsers" method = "post">
                <input type="search" id="inputSearch" name = "searchedUsers" class="form-control" placeholder="search" required autofocus>
                <a class="text-muted" name="searchedUsers" aria-label="Search">
                    <button type="submit" class="btn btn-secondary">search</button>

<#--                  <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" class="mx-3" role="img" viewBox="0 0 24 24" focusable="false"><title>Search</title><circle cx="10.5" cy="10.5" r="7.5"/><path d="M21 21l-5.2-5.2"/></svg>-->
                </a>

                <a class="btn btn-sm btn-outline-secondary" href="/userPage">Account</a>
                 <a class="btn btn-sm btn-outline-secondary"<a href="/logout">Выход</a>

             </form>
            </div>
            </form>
        </header>

        <div class="nav-scroller">
            <nav class="d-flex justify-content-start">
                <a class="p-2 text-muted" href="/articles">Статьи</a>
                <a class="p-2 text-muted" href="videos.ftlh">Видео</a>
                <a class="p-2 text-muted" href="/accounts">Аккаунты</a>
                <a class="p-2 text-muted" href="/api/products">Товары</a>
                <a class="p-2 text-muted" href="/api/orders">Заказы</a>



            </nav>
        </div>

        <div class="jumbotron p-4 p-md-5 text-white rounded bg-dark">
            <div class="col">
                <h1 class="display-6 font-italic">Немного истории</h1>
                <p class="lead">Интернет — глобальная сеть компьютерных ресурсов с коллективным доступом на основе использования единой стандартной схемы адресации, предназначенная для хранения и передачи данных. Наиболее популярная система передачи данных Интернета — Всемирная паутина, World Wide Web. Она предоставляет доступ к связанным между собой документам, расположенным на различных компьютерах, подключенных к Интернету.</p>
                <p class="lead"><a href="article1.ftlh" class="text-white font-weight-bold">Продолжить чтение...</a></p>
            </div>
            <div class="col">
                <div class="clearfix">
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/rQPBT2dimSg" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>
            </div>
        </div>
    </div>

    <div class = "container"><div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>

        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="images/spacex.jpg" class="d-block w-100" >
                <div class="carousel-caption d-none d-md-block">
                    <p><a href="article2.ftlh" class="text-white font-weight-bold">Запущены первые 60 спутников Starlink</a></p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="images/kvant.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <p><a href="article3.ftlh" class="text-white font-weight-bold">Квантово-запутанные сообщения передали на 50 километров</a></p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="images/rezonator.jpg" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <p><a href="article4.ftlh" class="text-white font-weight-bold">Оптический резонатор поможет создать квантовый интернет</a></p>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    </div>

    <aside class="col blog-sidebar">
        <div class = "container">
            <br class="p-4 mb-3 bg-light rounded">
            <h4 class="font-italic">Самые удивительные факты о Всемирной паутине</h4>
            <p>1. Первый в мире вебсайт появился в ЦЕРН в Швейцарии, сайт доступен до сих пор: он начал работу 6 августа 1991 года.</p>
            <p>2. Первую веб-камеру подключили в том же 1991 году в компьютерной лаборатории Кембриджского университета. Её единственной целью было наблюдение за отдельной кофеваркой - нельзя же дать кофе убежать!</p>
            <p>3. Слово "веб-сёрфинг" придумала ещё в 1992 году нью-йоркская библиотекарь Джин Армор Полли, впоследствии написавшая серию книг по безопасности в сфере интернет-услуг.</p>
            <p>4. Первой в мире страной, где доступ в интернет постулируется прописанным в законе правом, стала Финляндия: там это произошло в 2010 году.</p>
            <p>5. На первом ролике, загруженном в Youtube, основатель видеоплатформы и один из разработчиков PayPal Джавед Карим изучает слонов в зоопарке.</p>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/jNQXAC9IVRw" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            <br>
            <p>6. Первой страной, где будет запущена мобильная сеть 5G, обеспечивающая передачу данных на скорости до 20 гигабит в секунду, будет Южная Корея: это должно произойти уже в апреле, и испытывать скорость и качество передачи картинки будут на… движущихся голограммах.</p>
            <br>
            <h4 class="font-italic">Самые большие</h4>
            <br>
            <p>7. Физически больше всего пользователей интернета - предсказуемо - в Китае - около 800 миллионов человек, и это только примерно 60% населения страны.</p>
            <p>8. Самый большой вебсайт по объему трафика - Netflix: он съедает почти 15% мировой передачи данных.</p>
            <p>9. По данным за прошлый год, самый быстрый интернет в Европе - в Исландии: его скорость составляет 150 мегабит в секунду.</p>
            <p>10. Ряд источников утверждает, что почти 80% фотографий в сети - изображения обнажённых женщин. Подтвердить или опровергнуть эту информацию крайне непросто.</p>
            <img src="images/web.jpg" class="d-block w-100">
            <br>
            <h4 class="font-italic">Цифры, цифры...</h4>
            <br>
            <p>11. Какое количество людей на планете имеет подключение к сети? 4,05 млрд из примерно 7 миллиардов жителей планеты. При этом в Эритрее меньше 1% населения имеют выход в сеть.</p>
            <p>12. 51% трафика генерируют боты, а не реальные люди и сайты.</p>
            <p>13. Интернет охраняют семь реальных человек - у каждого ключ, который позволяет перезапустить мировую сеть в случае его захвата или технологической катастрофы.</p>
            <p>14. Главная инфраструктура мировой сети - 300 подводных кабелей, соединяющих континенты. Обрыв одного из них может оставить без связи десятки миллионов человек.</p>
            <br>
            <img src="images/web1.jpg" class="d-block w-100">
            <br>
            <p>15. Хранение и передача данных в интернете поглощает 20% мировой электроэнергии.</p>
            <p>16. Через пять лет на обслуживание всемирной паутины будет приходиться 5% всех выбросов углекислого газа в атмосферу.</p>
            <p>17. Гендерный дисбаланс в интернете стоит достаточно остро: глобальной сетью в мире пользуются на 12% меньше женщин, чем мужчин.</p>
            <p>18. По оценкам, доля "даркнета" от всей всемирной паутины может составлять 95% - но это учитывает все не индексируемые стандартными поисковиками страницы.</p>
            <br>
            <img src="images/web2.jpg" class="d-block w-100">
            <br>
            <p>19. В мире 2 млрд сайтов, на 0,1% (одно промилле) которых приходится половина глобального трафика.</p>
            <p>20. За одни сутки хакеры взламывают около 30 тыс. сайтов.</p>
            <p>21. 281 млрд электронных писем отправляют пользователи интернета каждый день.</p>
            <br>
            <h4 class="font-italic">Взрыв мозга</h4>
            <br>
            <p>22. Каждый файл, загруженный из интернета, делает устройство немного тяжелее: если доверять расчетам Калифорнийского университета в Беркли, весь интернет со всем его цифровым содержимым весит 50 граммов.</p>
            <p>23. Это сложно представить, но одна минута времени эквивалентна 87 тыс. часов просмотра визуального контента на Netflix и 400 часам загрузки видео на Youtube.</p>
            <p>24. За ту же минуту в приложении знакомств Tinder "свайпают вправо" - иными словами, соединяются - 18 тысяч пар.</p>
            <p>25. Согласно исследованию Statistic Brain, размер доходов, получаемых сайтами знакомств, составляет более миллиарда долларов в год.</p>
            <p>26. Изобретателем интернета называют Тима Бернерса-Ли, который выступает за его государственное регулирование и разработку Сетевого кодекса, с помощью которого пользователи могли бы осуществлять контроль за сетевой нейтральностью.</p>
            <br>
            <img src="images/timli.jpg" class="d-block w-100">
            <br>
            <p>27. Согласно исследованию социологического центра Pew Research, к 2025 году интернет станет восприниматься большинством людей базовой потребностью человека - то есть, такой же частью бытия, как электричество и водопровод.</p>
            <p>28. Попытка сосчитать количество элементарных частиц, из которых состоит среднее электронное письмо, удалась: в одно мейле - 2 млрд электронов.</p>
            <p>29. Эксперты уверены, что интернет нельзя выключить целиком, поскольку маршрутизаторы сетей не имеют единого внешнего управления.</p>
            <p>30. У глобальной паутины есть свой счётчик продолжительности существования сети: howoldistheinter.net. Там же в хронологическом порядке перечислены наиболее значимые события в истории интернета.</p>

            <div class="p-4">
                <h4 class="font-italic">Репозиторий</h4>
                <ol class="list-unstyled">
                    <li><a href="https://github.com/sonyakurguskina/SemesterWork">GitHub</a></li>
                </ol>
            </div>

        </div>
    </aside>

</div><!-- /.row -->

</main><!-- /.container -->

<footer class="blog-footer">
    <p>Made by Sonya Kurguskina 2021</p>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
