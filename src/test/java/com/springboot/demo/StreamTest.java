package com.springboot.demo;


import org.junit.Assert;
import org.junit.Test;
import com.springboot.demo.domain.User;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class StreamTest {

	@Test
	public void testMapList() {

		Map<String, String> map1 = new HashMap<>();
		map1.put("A", "A-Name");
		Map<String, String> map2 = new HashMap<>();
		map2.put("B", "B-Name");
		List<Map<String, String>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		Map<String, String> reduceMap = list.stream().reduce(new HashMap<>(), (i, j) -> {
			i.putAll(j);
			return i;
		});
		System.out.println(reduceMap);
	}

	@Test
	public void testStringMap() {

		List<String> list = Arrays.asList("AA", "BB", "CC");

		Map<String, String> map = list.stream().collect(Collectors.toMap(s -> s, s -> {return s + "-name";}));
		System.out.println(map);
	}
	@Test
	public void testStringMap2() {

		List<User> userList = new ArrayList<User>();
		userList.add(User.builder().code("a").name("aName").age(20).roleId(1).build());
		userList.add(User.builder().code("c").name("cName").age(10).roleId(1).build());
		userList.add(User.builder().code("b").name("bName").age(15).roleId(2).build());
		userList.add(User.builder().code("b").name("bName").age(18).roleId(2).build());

		Map<String, Integer> userMap = userList.stream().collect(Collectors.toMap(User::getCode, u -> u.getAge(), (v1, v2) -> v1));
		System.out.println(userMap);
	}

	@Test
	public void testParallel() {
		Instant start = Instant.now();
//		LongStream longStream = IntStream.rangeClosed(1, 4).mapToLong(this::sleep);
//		System.out.println(longStream.max());
		List<Long> list = IntStream.rangeClosed(1, 10).parallel().mapToLong(this::sleep).boxed().collect(Collectors.toList());
		list.stream().forEach(System.out::print);

//		IntStream.rangeClosed(1, 4).parallel().forEach(i -> {this.sleep(i);}); // .sequential()
		Instant end = Instant.now();
		System.out.println("end and time:" + (end.toEpochMilli() - start.toEpochMilli()));
	}

	@Test
	public void testParallelEx() {
		Instant start = Instant.now();
		List<Long> list = IntStream.rangeClosed(1, 10).parallel().mapToLong(this::sleep).boxed().collect(Collectors.toList());
		list.stream().forEach(System.out::print);

		Instant end = Instant.now();
		System.out.println();
		System.out.println("end and time:" + (end.toEpochMilli() - start.toEpochMilli()));
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

	public Long sleep(int i) {
		try {
			Thread.sleep(1 * 1000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("sleep 1 seconds,index:" + i + ", thread id:" + Thread.currentThread().getId());
		return Long.valueOf(i);
	}

	@Test
	public void testAllBlue() {

		List<User> userList = new ArrayList<User>();
		userList.add(User.builder().code("a").name("aName").age(20).roleId(1).build());
		userList.add(User.builder().code("c").name("cName").age(10).roleId(1).build());
		userList.add(User.builder().code("b").name("bName").age(15).roleId(2).build());
		userList.add(User.builder().code("b").name("bName").age(15).roleId(2).build());

		// 去重
		List<User> distList = userList.stream().distinct().collect(Collectors.toList());
		Assert.assertEquals(3, distList.size());

		// 排序 空内容处理
		List<User> sortAndLimitList = distList.stream().sorted(Comparator.nullsFirst(Comparator.comparing(User::getAge, this::compareInteger)).reversed()).collect(Collectors.toList());
		sortAndLimitList.forEach(System.out::println);

		// TO Map, Set, List (Collectors.toSet Or toList)
		Map<String, User> userMap = distList.stream().collect(Collectors.toMap(User::getCode, u -> u));
		List<String> codeList = distList.stream().map(User::getCode).collect(Collectors.toList());
		userMap.forEach((k, v) -> System.out.println(k + ":" + v));
		// To Map fix Duplicate key
		Map<String, User> userMapDistinct = userList.stream().collect(Collectors.toMap(u -> u.getCode(), u -> u, (v1, v2) -> v2));
		userMapDistinct.forEach((k, v) -> System.out.println(k + ":" + v));


		// Statistics: sum max age  and so on
		int sumAge1 = distList.stream().collect(Collectors.reducing(0, User::getAge, (i, j) -> i + j));
		int sumAge2 = distList.stream().collect(Collectors.reducing(0, User::getAge, Integer::sum));
		int sumAge3 = distList.stream().mapToInt(User::getAge).sum();
		int sumAge4 = distList.stream().collect(Collectors.summingInt(User::getAge));
		Assert.assertEquals(45, sumAge1);
		Assert.assertEquals(45, sumAge2);
		Assert.assertEquals(45, sumAge3);
		Assert.assertEquals(45, sumAge4);

		Optional<User> maxAgeUser = distList.stream().max(Comparator.comparingInt(User::getAge));
		Assert.assertEquals("a", maxAgeUser.get().getCode());

		int maxAge1 = distList.stream().collect(Collectors.reducing(0, User::getAge, Integer::max));
		int maxAge2 = distList.stream().mapToInt(User::getAge).max().orElse(-1);
		Assert.assertEquals(20, maxAge1);
		Assert.assertEquals(20, maxAge2);

		Double ageAge = distList.stream().collect(Collectors.averagingInt(User::getAge));
		Assert.assertEquals(15, ageAge.doubleValue(), 0.1);

		IntSummaryStatistics sta = distList.stream().collect(Collectors.summarizingInt(User::getAge));
		Assert.assertEquals(15, sta.getAverage(), 0.1);
		Assert.assertEquals(20, sta.getMax());
		Assert.assertEquals(3, sta.getCount());
		Assert.assertEquals(45, sta.getSum());

		// Join
		String codes = distList.stream().map(User::getCode).collect(Collectors.joining("-"));
		Assert.assertEquals("a-c-b", codes);

		// reduce TODO
		//int cus = distList.stream().reduce(1, User::getAge, Integer::sum);

		// Group By TODO
		distList.stream().collect(Collectors.groupingBy(User::getRoleId));

		// Filter
		List<User> filterList = distList.stream().filter(d -> "a".equals(d.getCode())).map(d -> {
			d.setName(d.getName() + "Change");
			return d;
		}).collect(Collectors.toList());

		filterList.forEach(System.out::println);

		// Parameter join
		List<String> joinParamList = distList.stream().map(d -> d.getCode() + "-" + d.getName()).collect(Collectors.toList());
		joinParamList.forEach(System.out::println);

		// findOne
		boolean hasSomeOne = distList.stream().anyMatch(d -> "e".equals(d.getCode()));
		Assert.assertFalse(hasSomeOne);
		
		// findOne
		User first = distList.stream().filter(u -> "c".equals(u.getCode())).findFirst().orElseThrow(() -> new NullPointerException());
		System.out.println(first);
	}

	// 比较两个参数大小
	private int compareInteger(Integer a1, Integer a2) {
		int r = 0;
		if (a1 == null) {
			r = -1;
		} else if (a2 == null) {
			r = 1;
		} else {
			r = a1.compareTo(a2);
		}
		return r;
	}
}
