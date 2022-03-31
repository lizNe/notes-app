package persistence

import models.Note
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.io.PrintWriter


class YAMLSerializer(private val file: File) : Serializer {

    @Throws(Exception::class)
    override fun read(): Any {
        val inputStream: InputStream = FileInputStream(file)
        val yaml = Yaml(Constructor(ArrayList<Note>()::class.java))
        val obj: ArrayList<Note> = yaml.load(inputStream)
//        val objectMapper = ObjectMapper(YAMLFactory())
//        val obj: ArrayList<Note> = objectMapper.readValue(file, ArrayList<Note>()::class.java)
        return obj
    }

    @Throws(Exception::class)
    override fun write(obj: Any?) {
        val writer = PrintWriter(file)
        val options = DumperOptions()
        options.indent = 2
        options.isPrettyFlow = true
        options.defaultFlowStyle = DumperOptions.FlowStyle.BLOCK
        val yaml = Yaml(options)
        yaml.dump(obj, writer)
//        val objectMapper = ObjectMapper(YAMLFactory())
//        objectMapper.writeValue(file,obj)
    }
}




