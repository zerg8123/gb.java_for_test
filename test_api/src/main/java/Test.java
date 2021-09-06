import okhttp3.ResponseBody;
import retrofit.api.MiniMarketApi;
import retrofit.dto.Category;
import retrofit.dto.ProductDto;
import retrofit.utils.RetrofitGetter;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        RetrofitGetter getter = new RetrofitGetter();
        Retrofit retrofit = getter.getInstance();

        MiniMarketApi marketApi = retrofit.create(MiniMarketApi.class);

        Response<List<ProductDto>> productsResp = marketApi.getProduct().execute();

//        List<ProductDto> products = productsResp.body();
//        System.out.println(products);
//
//        ProductDto newProduct = ProductDto.builder()
//                .id(6L)
//                .title("honey")
//                .price(225L)
//                .categoryTitle(Category.FOOD.getTitle())
//                .build();

//        marketApi.updateProduct(newProduct).execute();
//        System.out.println("New product created");
    }
}
