/**
 * Генерирует данные, используемые внутри компонентов - стили, заглушки и т.д.
 */
export default class DynamicAssetFactory {
  static stubForShow = () => ({
    title: '(no title)',
    title_rus: '(no title)',
    description: '(no description)',
    pic: 'http://wizardvarnish.com/wv/wp-content/uploads/2014/01/mm1u4lDBjR1qz4rgp.jpg' // nobody expects it!
  })

  static jumbotronShowStyle = (show) => ({
    backgroundSize: 'cover',
    height: '300px',
    backgroundImage: `url(${show.pic || 'http://wizardvarnish.com/wv/wp-content/uploads/2014/01/mm1u4lDBjR1qz4rgp.jpg'})`,
    borderRadius: 0,
    color: '#fff',
    textShadow: '3px 2px 2px #3a3946'
  })

}

