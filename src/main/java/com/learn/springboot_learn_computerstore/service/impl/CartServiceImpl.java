package com.learn.springboot_learn_computerstore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.springboot_learn_computerstore.entity.Cart;
import com.learn.springboot_learn_computerstore.ex.CartInfoNotExistsException;
import com.learn.springboot_learn_computerstore.ex.DeleteException;
import com.learn.springboot_learn_computerstore.mapper.CartMapper;
import com.learn.springboot_learn_computerstore.service.ICartService;
import com.learn.springboot_learn_computerstore.vo.CartVo;

@Service
public class CartServiceImpl implements ICartService{

    @Autowired(required = false)
    private CartMapper cartMapper;
 
    //  @Override
    //  public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
 
    //      //根据参数pid和uid查询购物车中该商品是否已经存在
    //      Cart result = cartMapper.queryCartByUidAndPid(uid, pid);
 
    //      //Integer cid = result.getCid();
    //      Date date = new Date();
    //      if (result == null) {
    //          Cart cart = new Cart();
 
    //          //封装数据：uid,pid,amount
    //          cart.setUid(uid);
    //          cart.setPid(pid);
    //          cart.setNum(amount);//注意前端传来amount时并没有和数据库商品数量进行求和
 
    //          //查询商品数据，得到商品价格并封装
    //          Product product = productMapper.findById(pid);
    //          cart.setPrice(product.getPrice());
 
    //          //封装数据：4个日志
    //          cart.setCreatedUser(username);
    //          cart.setCreatedTime(date);
    //          cart.setModifiedUser(username);
    //          cart.setModifiedTime(date);
 
    //          Integer rows = cartMapper.addCart(cart);
    //          if (rows != 1) {
    //              throw new InsertException("插入数据时出现未知异常");
    //          }
    //      } else {
    //          //从查询结果中取出原数量，与参数amount相加，得到新的数量
    //          Integer num = result.getNum() + amount;//加入购物车时只会有+不可能有-
    //          //int UpdateCartNumByCid(Integer num,String modifiedUser, Date modifiedTime,Integer cid);
    //          Integer rows = cartMapper.UpdateCartNumByCid(
    //              num,
    //              username,
    //              date,
    //              result.getCid());
    //          if (rows != 1) {
    //              throw new InsertException("更新数据时产生未知异常");
    //          }
    //      }
    //  }
    
/**
     * Description : 根据uid和aid查询数据的具体逻辑
     * @date 2022/7/17
     * @param uid 用户uid
     * @param pid 购物车pid信息
     * @return top.year21.computerstore.entity.Cart
     **/
    @Override
    public Cart queryCartByUidAndPid(Integer uid, Integer pid) {
       return cartMapper.queryCartByUidAndPid(uid,pid);
    }

    /**
     * Description : 更新cart数据的具体逻辑
     * @date 2022/7/17
     * @param cart 实体类对象
     * @return int
     **/
    @Override
    public int UpdateCartInfo(Cart cart, String modifiedUser, Date modifiedTime) {
        //更改修改人和修改时间的字段
        cart.setModifiedUser(modifiedUser);
        cart.setModifiedTime(modifiedTime);
        //执行修改
        return cartMapper.updateCartInfo(cart);
    }

    /**
     * Description : 新增cart数据的抽象方法
     * @date 2022/7/17
     * @param cart 实体类对象
     * @return int
     **/
    @Override
    public int addCart(Cart cart,String createdUser,Date createdTime,String modifiedUser, Date modifiedTime) {
        //取得当前商品的pid和用户uid
        Integer pid = cart.getPid();
        Integer uid = cart.getUid();
        //查询当前pid在当前用户的购物车中是否存在
        Cart destCart = cartMapper.queryCartByUidAndPid(uid, pid);

        //根据查询的结果做出不同动作
        if (destCart == null){ //表示不存在，则直接添加
            //补全其他四个字段
            cart.setCreatedUser(createdUser);
            cart.setCreatedTime(createdTime);
            cart.setModifiedUser(modifiedUser);
            cart.setModifiedTime(modifiedTime);

            //执行插入操作
            return cartMapper.addCart(cart);
        }else { //表示该用户已存在该产品的数据
            //取出查询的数据数量
            Integer destNum = destCart.getNum();
            //取出新添加产品的数量
            Integer cartNum = cart.getNum();

            //计算最终的数量
            Integer endNum = destNum + cartNum;
            //并更新需要更新的字段
            destCart.setNum(endNum);
            destCart.setModifiedUser(modifiedUser);
            destCart.setModifiedTime(modifiedTime);

            //执行更新操作
            return cartMapper.updateCartInfo(destCart);
        }

    }

    /**
     * Description : 根据uid查询用户购物车信息的具体逻辑
     * @date 2022/7/17
     * @param uid 用户uid
     * @return java.util.List<top.year21.computerstore.entity.Cart>
     **/
    @Override
    public List<CartVo> queryCartByUid(Integer uid) {
        return cartMapper.queryAllCartsByUid(uid);
    }

    /**
     * Description : 根据cid查询用户cart信息的具体逻辑
     * @date 2022/7/17
     * @param cid cart的id
     * @return top.year21.computerstore.entity.Cart
     **/
    @Override
    public Cart queryCartByCid(Integer cid) {
        return cartMapper.queryCartByCid(cid);
    }

    /**
     * Description : 根据cid修改对应购物车信息数量的具体逻辑
     * @date 2022/7/18
     * @param num 修改数量
     * @param modifiedUser 修改人
     * @param modifiedTime 修改时间
     * @param cid cart的cid
     * @return int
     **/
    @Override
    public int updateCartNumByCid(Integer num, String modifiedUser, Date modifiedTime, Integer cid) {
        //现根据cid查询此数据是否存在
        Cart cart = cartMapper.queryCartByCid(cid);

        if (cart == null){
            throw new CartInfoNotExistsException("购物车内无这条数据，增加失败");
        }

        return cartMapper.UpdateCartNumByCid(num,modifiedUser,modifiedTime,cid);
    }

    /**
     * Description : 根据cid返回CartVo对象的具体逻辑
     * @date 2022/7/18
     * @param cid cart的id
     * @return top.year21.computerstore.vo.CartVo
     **/
    @Override
    public CartVo queryCartVoByCid(Integer cid) {
        return cartMapper.queryCartVoByCid(cid);
    }

    /**
     * Description : 根据cids数组的内容查询cart信息的具体逻辑
     * @date 2022/7/18
     * @param cids 查询的cids数组
     * @return java.util.List<top.year21.computerstore.entity.Cart>
     **/
    @Override
    public List<CartVo> queryCartByCids(Integer[] cids) {
        List<CartVo> list = new ArrayList<>();
        for (Integer cid : cids) {
            CartVo destCartVo = cartMapper.queryCartVoByCid(cid);
            if (destCartVo != null){
                list.add(destCartVo);
            }
        }
        return list;
    }

    /**
     * Description : 根据cids删除cart信息的具体逻辑
     * @date 2022/7/19
     * @param cid 购物车商品的cid
     * @return int
     **/
    @Override
    public int deleteCartByCid(Integer cid) {
        int result = cartMapper.deleteCartByCid(cid);

        if (result == 0){
            throw new DeleteException("服务器异常，删除失败");
        }
        return result;
    }

    /**
     * Description : 根据uid和pid删除对应的t_cart表中的数据的具体逻辑
     * @date 2022/7/20
     * @param uid 用户uid
     * @param pid 商品pid
     * @return int
     **/
    @Override
    public int deleteCartByUidAndPid(Integer uid, Integer pid) {
        int result = cartMapper.deleteCartByUidAndPid(uid, pid);
        if (result == 0){
            throw new DeleteException("服务器异常，删除购物车商品失败!!");
        }
        return result;
    }
}
