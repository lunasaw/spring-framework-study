package org.springframework.luna.json;

import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.filter.PropertyFilter;
import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.HashSet;
import java.util.List;

/**
 * @author chenzhangyue
 * 2023/3/10
 */
public class FastjsonTest {

	public static void main(String[] args) {
		String data = "{\"aPPDiskCapacity\":\"\",\"aPPMemory\":\"\",\"aPPV\":\"\",\"alt\":\"\",\"androidId\":\"\",\"apiName\":\"retailRalation.apply\",\"apiVersion\":\"1.0\",\"appStatus\":\"\",\"brand\":\"\",\"build\":\"\",\"cUId\":\"081bdd92ac7a7295\",\"channel\":\"\",\"context\":{\"content-length\":\"68\",\"referer\":\"https://h5.weidian.com/\",\"duid\":\"712867034\",\"sec-fetch-site\":\"same-site\",\"scheme\":\"https\",\"login_type\":\"LOGIN_USER_TYPE_MASTER\",\"origin\":\"https://h5.weidian.com\",\"login_source\":\"LOGIN_USER_SOURCE_MASTER\",\"wdtoken\":\"39c236f1\",\"deviceId\":\"081bdd92ac7a7295\",\"sid\":\"712867034\",\"uid\":\"712867034\",\"host\":\"thor.weidian.com\",\"x-real-port\":\"25157\",\"content-type\":\"application/x-www-form-urlencoded\",\"is_login\":\"true\",\"sec-fetch-mode\":\"cors\",\"cuid\":\"081bdd92ac7a7295\",\"accept-language\":\"zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7\",\"cookie\":\"wdtoken=39c236f1; __spider__visitorid=081bdd92ac7a7295; is_login=true; login_type=LOGIN_USER_TYPE_MASTER; uid=712867034; duid=712867034; sid=712867034; v-components/tencent-live-plugin@wfr=c; v-components/clean-up-advert@private_domain=1239506275; v-components/clean-up-advert@wx_app=1239506275; login_source=LOGIN_USER_SOURCE_MASTER; vc_fpcookie=6d04849a-9cb9-26b1-12aa-850c6028ac38; login_token=_EwWqqVIQI3NItl1NapEq1wPTJ9n0FyD_GuCOLwo0nNKltAr8UEblN_6TErIh3Ow5LtiFmq_yh1YjLiEb9tif5B_46Y4c-QYcKDqMz77iGJNOirbHpv-6GSo7FtTai5SIkp_PS3Yjt9udJUysZC4yVNBL372Wq238CbUmNe5BXIC6O_Cbpq5BR-PSOt9e78mR08faouojc-HpWkR5SgU5hyGx_pOUm7LmSK3N2mES-o1ura_rDoMhwhM9juwmwrKa3uNh2p6y; __spider__sessionid=e064c6b832824309\",\"__spider__visitorid\":\"081bdd92ac7a7295\",\"vc_fpcookie\":\"6d04849a-9cb9-26b1-12aa-850c6028ac38\",\"__spider__sessionid\":\"e064c6b832824309\",\"x-forwarded-for\":\"223.104.150.5\",\"accept\":\"application/json, text/plain, */*\",\"x-real-ip\":\"223.104.150.5\",\"shop_id\":\"712867034\",\"x-requested-with\":\"com.tencent.mm\",\"login_token\":\"_EwWqqVIQI3NItl1NapEq1wPTJ9n0FyD_GuCOLwo0nNKltAr8UEblN_6TErIh3Ow5LtiFmq_yh1YjLiEb9tif5B_46Y4c-QYcKDqMz77iGJNOirbHpv-6GSo7FtTai5SIkp_PS3Yjt9udJUysZC4yVNBL372Wq238CbUmNe5BXIC6O_Cbpq5BR-PSOt9e78mR08faouojc-HpWkR5SgU5hyGx_pOUm7LmSK3N2mES-o1ura_rDoMhwhM9juwmwrKa3uNh2p6y\",\"accept-encoding\":\"gzip, deflate\",\"user-agent\":\"Mozilla/5.0 (Linux; Android 12; NOH-AN00 Build/HUAWEINOH-AN00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/107.0.5304.141 Mobile Safari/537.36 XWEB/5015 MMWEBSDK/20230202 MMWEBID/4090 MicroMessenger/8.0.33.2320(0x2800213D) WeChat/arm64 Weixin NetType/5G Language/zh_CN ABI/arm64 miniProgram/wx9794a0135ea909fc\",\"sec-fetch-dest\":\"empty\"},\"defaultUserId\":\"712867034\",\"h\":0,\"iCCId\":\"\",\"iDFA\":\"\",\"iDFV\":\"\",\"imei\":\"\",\"imsi\":\"\",\"input\":[{\"supplySellerId\":1734574774},{\"$ref\":\"..\"}],\"ip\":\"223.104.150.5\",\"isLogin\":\"true\",\"lat\":\"\",\"loginToken\":\"_EwWqqVIQI3NItl1NapEq1wPTJ9n0FyD_GuCOLwo0nNKltAr8UEblN_6TErIh3Ow5LtiFmq_yh1YjLiEb9tif5B_46Y4c-QYcKDqMz77iGJNOirbHpv-6GSo7FtTai5SIkp_PS3Yjt9udJUysZC4yVNBL372Wq238CbUmNe5BXIC6O_Cbpq5BR-PSOt9e78mR08faouojc-HpWkR5SgU5hyGx_pOUm7LmSK3N2mES-o1ura_rDoMhwhM9juwmwrKa3uNh2p6y\",\"loginType\":\"LOGIN_USER_TYPE_MASTER\",\"lon\":\"\",\"mId\":\"\",\"mac\":\"\",\"machineModel\":\"\",\"mobileStation\":\"\",\"netSubType\":\"\",\"network\":\"\",\"newPlatform\":\"H5\",\"oS\":\"\",\"platform\":\"android\",\"request\":{\"allHttpRequestParameters\":{\"wdtoken\":[\"39c236f1\"],\"param\":[\"{\\\"supplySellerId\\\":\\\"1734574774\\\"}\"]},\"apiName\":\"retailRalation.apply\",\"apiVersion\":\"1.0\",\"attributes\":{},\"cookies\":{\"uid\":\"712867034\",\"duid\":\"712867034\",\"__spider__visitorid\":\"081bdd92ac7a7295\",\"login_type\":\"LOGIN_USER_TYPE_MASTER\",\"vc_fpcookie\":\"6d04849a-9cb9-26b1-12aa-850c6028ac38\",\"__spider__sessionid\":\"e064c6b832824309\",\"login_source\":\"LOGIN_USER_SOURCE_MASTER\",\"login_token\":\"_EwWqqVIQI3NItl1NapEq1wPTJ9n0FyD_GuCOLwo0nNKltAr8UEblN_6TErIh3Ow5LtiFmq_yh1YjLiEb9tif5B_46Y4c-QYcKDqMz77iGJNOirbHpv-6GSo7FtTai5SIkp_PS3Yjt9udJUysZC4yVNBL372Wq238CbUmNe5BXIC6O_Cbpq5BR-PSOt9e78mR08faouojc-HpWkR5SgU5hyGx_pOUm7LmSK3N2mES-o1ura_rDoMhwhM9juwmwrKa3uNh2p6y\",\"wdtoken\":\"39c236f1\",\"is_login\":\"true\",\"sid\":\"712867034\"},\"headers\":{\"sec-fetch-mode\":\"cors\",\"content-length\":\"68\",\"referer\":\"https://h5.weidian.com/\",\"sec-fetch-site\":\"same-site\",\"accept-language\":\"zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7\",\"cookie\":\"wdtoken=39c236f1; __spider__visitorid=081bdd92ac7a7295; is_login=true; login_type=LOGIN_USER_TYPE_MASTER; uid=712867034; duid=712867034; sid=712867034; v-components/tencent-live-plugin@wfr=c; v-components/clean-up-advert@private_domain=1239506275; v-components/clean-up-advert@wx_app=1239506275; login_source=LOGIN_USER_SOURCE_MASTER; vc_fpcookie=6d04849a-9cb9-26b1-12aa-850c6028ac38; login_token=_EwWqqVIQI3NItl1NapEq1wPTJ9n0FyD_GuCOLwo0nNKltAr8UEblN_6TErIh3Ow5LtiFmq_yh1YjLiEb9tif5B_46Y4c-QYcKDqMz77iGJNOirbHpv-6GSo7FtTai5SIkp_PS3Yjt9udJUysZC4yVNBL372Wq238CbUmNe5BXIC6O_Cbpq5BR-PSOt9e78mR08faouojc-HpWkR5SgU5hyGx_pOUm7LmSK3N2mES-o1ura_rDoMhwhM9juwmwrKa3uNh2p6y; __spider__sessionid=e064c6b832824309\",\"scheme\":\"https\",\"origin\":\"https://h5.weidian.com\",\"x-forwarded-for\":\"223.104.150.5\",\"accept\":\"application/json, text/plain, */*\",\"x-real-ip\":\"223.104.150.5\",\"host\":\"thor.weidian.com\",\"x-real-port\":\"25157\",\"x-requested-with\":\"com.tencent.mm\",\"content-type\":\"application/x-www-form-urlencoded\",\"accept-encoding\":\"gzip, deflate\",\"sec-fetch-dest\":\"empty\",\"user-agent\":\"Mozilla/5.0 (Linux; Android 12; NOH-AN00 Build/HUAWEINOH-AN00; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/107.0.5304.141 Mobile Safari/537.36 XWEB/5015 MMWEBSDK/20230202 MMWEBID/4090 MicroMessenger/8.0.33.2320(0x2800213D) WeChat/arm64 Weixin NetType/5G Language/zh_CN ABI/arm64 miniProgram/wx9794a0135ea909fc\"},\"httpRequestParameters\":{\"wdtoken\":[\"39c236f1\"]},\"method\":\"POST\",\"openApi\":false,\"param\":\"{\\\"supplySellerId\\\":\\\"1734574774\\\"}\",\"remoteAddr\":\"223.104.150.5\",\"requestUri\":\"/fenxiao/retailRalation.apply/1.0\",\"schema\":\"https\",\"scope\":\"fenxiao\",\"xschema\":\"http\"},\"response\":{\"code\":0,\"compatible\":false,\"cookies\":[],\"headers\":{},\"message\":\"OK\"},\"sUId\":\"\",\"schema\":\"https\",\"scope\":\"fenxiao\",\"sellerIdentity\":\"\",\"serialNum\":\"\",\"shopId\":712867034,\"thorApi\":{\"cluster\":\"common\",\"openApi\":\"\",\"auth\":\"VERIFY_AUTH\",\"realScene\":\"\",\"author\":\"\",\"appId\":\"\",\"name\":\"retailRalation.apply\",\"resultKey\":\"\",\"traceUser\":true,\"version\":[\"1.0\"],\"desc\":\"申请全店分销\"},\"uId\":\"712867034\",\"visitorId\":\"\",\"w\":0,\"wMac\":\"\",\"wSSId\":\"\",\"xschema\":\"http\"}";

		JSONObject jsonObject = JSON.parseObject(data);
		String key = "deviceId,x-forwarded-for,x-real-ip,cookie,__spider__visitorid,__spider__sessionid,wdtoken,x-real-port,sec-fetch-dest,sec-fetch-site,login_source,isLogin,WD_s_wduss,vc_fpcookie,sec-ch-ua,sec-ch-ua-mobile,sec-fetch-mode,sec-ch-ua-platform,login_token";
		List<String> list = Splitter.on(",").splitToList(key);
		HashSet<@Nullable String> filiterKey = Sets.newHashSet(list);

		PropertyFilter propertyFilter = new PropertyFilter() {

			@Override
			public boolean process(Object object, String name, Object value) {
				return !filiterKey.contains(name);
			}
		};

		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {

			String string = JSON.toJSONString(jsonObject, (PropertyFilter) (object, name, value) -> !filiterKey.contains(name));
//			System.out.println(string);
		}
		long t2 = System.currentTimeMillis();

		for (int i = 0; i < 1000000; i++) {

			String string = JSON.toJSONString(jsonObject);
//			System.out.println(string);
		}
		long t3 = System.currentTimeMillis();

		System.out.println(t2-t1);
		System.out.println(t3-t2);

	}

}
