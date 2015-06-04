package jp.kt.archiver;

import static org.junit.Assert.*;
import jp.kt.fileio.FileUtil;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TargzTest {
	private static final String ORG_DIR = "src/main/java";
	private static final String COMPRESS_FILE = "target/temp_for_test/compress.tar.gz";
	private static final String DECOMPRESS_DIR = "target/temp_for_test/targz";

	@BeforeClass
	public static void setUp() throws Exception {
		new FileUtil(COMPRESS_FILE).delete();
		new FileUtil(DECOMPRESS_DIR).delete();
		new FileUtil(DECOMPRESS_DIR).makeDirectory();
	}

	@Test
	public void testCompress() {
		try {
			new TarGzArchiver().compress(ORG_DIR, COMPRESS_FILE);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testDecompress() {
		try {
			new TarGzArchiver().decompress(COMPRESS_FILE, DECOMPRESS_DIR);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
