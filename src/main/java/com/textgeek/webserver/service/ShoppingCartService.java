package com.textgeek.webserver.service;


import com.textgeek.webserver.model.Profile;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {
    //@Autowired
    //private static ShoppingCartRepository shoppingCartRepository;

    //@Autowired
    //private static BookCustomRepositoryImpl bookCustomRepositoryipml;

    /*public List<ShoppingCart> listShoppingCart (Profile profile){
        return shoppingCartRepository.findByProfile(profile);
    }/*


    /*public static Integer addBook(Integer book_id, Integer quantity, Profile profile){
        Integer addQuantity = quantity;

        Map<String, String> map = new HashMap<>();
        map.put("id", book_id.toString());

        //bookCustomRepositoryipml = new BookCustomRepositoryImpl();
        // Waiting for the Book Repository method of delovution of one book
        Book book = (Book) bookCustomRepositoryipml.findAllWithParams(map);

        ShoppingCart shoppingCart = shoppingCartRepository.findByProfileAndProduct(profile, book);

        if(shoppingCart != null){

            addQuantity = shoppingCart.getQuantity() + quantity;
            shoppingCart.setQuantity(addQuantity);
        }else{
            shoppingCart = new ShoppingCart();
            shoppingCart.setQuantity(quantity);
            shoppingCart.setProfile(profile);
            shoppingCart.setBook((List<Book>) book);

        }
        shoppingCartRepository.save(shoppingCart);
        return addQuantity;
    }*/

    /*public void updateQuantity(Integer book_id, Integer quantity, Profile profile){

        shoppingCartRepository.UpdateQuantity(quantity, book_id, profile.getId());
        Book book = bookCustomRepositoryipml.findAllWithParams(book_id).get();

    }

    @PutMapping("/shoppingcart/{book_id}/{quantity}")

    public String updateQuantity(@PathVariable("book_id") Integer book_id, @PathVariable("quantity") Integer quantity/*, @AuthenticationPrincipal Authentication authentication ) {
        if(authentication == null|| authentication instanceof AnonymousAuthentificationToken){
            return "Please log in to add the product to the ShoppingCart";
        }
        /*Profile profile = profileservices.getCurrnetlyLoggedInCustumer(/*authentication);
/*
        updateQuantity(book_id, quantity, profile);
        return quantity + " items were added to the ShoppingCart";
    }

    @DeleteMapping("/shoopingcart/{userid}/book/{book_id}")
    public String RemoveBook (@PathVariable("book_id") Integer book_id, @PathVariable("userid") Integer user_id/*, @AuthenticationPrincipal Authentication authentication ) {
        if(authentication == null|| authentication instanceof AnonymousAuthentificationToken){
            return "Please log in to removed the product from your cart";
        }
        //Profile profile = profileservices.getCurrnetlyLoggedInCustumer(/*authentication);


        shoppingCartRepository.DeleteByProfileandBook(user_id, book_id);

        return "booked deleted";
    }*/

}


