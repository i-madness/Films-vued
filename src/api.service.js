export default class ApiService {
    static fetchShowList($http, pageNum) {
        return $http.get(`https://i-madness.github.io/api/tvshows/page_${pageNum}.json`)
    }
}