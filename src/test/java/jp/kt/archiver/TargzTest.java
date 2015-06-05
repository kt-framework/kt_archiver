package jp.kt.archiver;

import static org.junit.Assert.*;

import java.io.IOException;

import jp.kt.fileio.FileUtil;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * tarファイル処理のテストクラス.
 *
 * @author tatsuya.kumon
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TargzTest {
	private static final String ORG_DIR = "src/main/java";
	private static final String COMPRESS_FILE = "target/temp_for_test/compress.tar.gz";
	private static final String DECOMPRESS_DIR = "target/temp_for_test/targz";

	/**
	 * テスト前に以前のファイルとディレクトリを削除.
	 *
	 * @throws IOException
	 *             入出力エラーが発生した場合
	 */
	@BeforeClass
	public static void setUp() throws IOException {
		new FileUtil(COMPRESS_FILE).delete();
		new FileUtil(DECOMPRESS_DIR).delete();
		new FileUtil(DECOMPRESS_DIR).makeDirectory();
	}

	/**
	 * 圧縮テスト.
	 */
	@Test
	public void testCompress() {
		try {
			new TarGzArchiver().compress(ORG_DIR, COMPRESS_FILE);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	/**
	 * 解凍テスト.
	 */
	@Test
	public void testDecompress() {
		try {
			new TarGzArchiver().decompress(COMPRESS_FILE, DECOMPRESS_DIR);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
